package com.example.project_sop.controller;

import com.example.project_sop.HoldBook;
import com.example.project_sop.pojo.Book;
import com.example.project_sop.pojo.Hold;
import com.example.project_sop.pojo.User;
import com.example.project_sop.repository.BookService;
import com.example.project_sop.repository.HoldService;
import com.example.project_sop.repository.UserService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HoldController extends HoldBook{
    @Autowired
    private HoldService holdService;
    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping(value = "/holdBook/{title}", method = RequestMethod.GET)
    public ResponseEntity<?> getBookByTitle(@PathVariable("title") String title) {
        Book book = bookService.retrieveBookByTitle(title);
        rabbitTemplate.convertAndSend("SOP_Project_Direct", "holdBook", title);
        return ResponseEntity.ok(book);
    }

    @RequestMapping(value = "/updateBookUsername/{username}/{title}", method = RequestMethod.GET)
    public ResponseEntity<?> getHoldBookByUsername(@PathVariable("username") String username, @PathVariable("title") String title) {
        rabbitTemplate.convertAndSend("SOP_Project_Direct", "holdBook", title);
        User user = userService.findUser(username);
        Hold hold = holdService.retrieveHoldBookByUsername(username);
        if (hold != null) {
            holdBookTitle.add(title);
            Hold hold_update = holdService.createHoldBook(new Hold(hold.get_id(), null, username, holdBookTitle));
            return ResponseEntity.ok(hold_update);
        }
        else {
            holdBookTitle.add(title);
            Hold hold_create = holdService.createHoldBook(new Hold(null, null, username, holdBookTitle));
            return ResponseEntity.ok(hold_create);
        }
    }

    @RequestMapping(value = "/deleteHoldBook/{username}/{title}", method = RequestMethod.GET)
    public boolean deleteHoldBook(@PathVariable("username") String username, @PathVariable("title") String title) {
        Hold holdUser = holdService.retrieveHoldBookByUsername(username);
        Hold hold = holdService.retrieveHoldBookByTitle(title);

        if ( holdUser != null) {
            boolean status = holdService.deleteHoldBook(hold);
            return status;
        }
        else {
            return false;
        }
    }
}
