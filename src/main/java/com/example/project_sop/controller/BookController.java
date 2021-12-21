package com.example.project_sop.controller;
import com.example.project_sop.pojo.Book;
import com.example.project_sop.repository.BookService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public ResponseEntity<?> getBooks() {
        List<Book> books = bookService.retrieveBooks();
        return ResponseEntity.ok(books);
    }

    @RequestMapping(value = "/bookTitle/{title}", method = RequestMethod.GET)
    public ResponseEntity<?> getBookByTitle(@PathVariable("title") String title) {
        Book book = bookService.retrieveBookByTitle(title);
        rabbitTemplate.convertAndSend("SOP_Project_Direct", "title", title);
        return ResponseEntity.ok(book);
    }

    @RequestMapping(value = "/bookIsbn/{isbn}", method = RequestMethod.GET)
    public ResponseEntity<?> getBookByIsbn(@PathVariable("isbn") String isbn) {
        Book book = bookService.retrieveBookByIsbn(isbn);
        rabbitTemplate.convertAndSend("SOP_Project_Direct", "isbn", isbn);
        return ResponseEntity.ok(book);
    }

    @RequestMapping(value = "/bookId/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getBookByID(@PathVariable("id") Integer id) {
        Book book = bookService.retrieveBookById(id);
        return ResponseEntity.ok(book);
    }

    @RequestMapping(value = "/bookAuthor/{authors}", method = RequestMethod.GET)
    public ResponseEntity<?> getBookByAuthor(@PathVariable("authors") String authors) {
        List<Book> book = bookService.retrieveBookByAuthor(authors);
        rabbitTemplate.convertAndSend("SOP_Project_Direct", "authors", authors);
        return ResponseEntity.ok(book);
    }

    @RequestMapping(value = "/bookCategories/{categories}", method = RequestMethod.GET)
    public ResponseEntity<?> getBookByCategories(@PathVariable("categories") String categories) {
        List<Book> book = bookService.retrieveBookByCategories(categories);
        rabbitTemplate.convertAndSend("SOP_Project_Direct", "categories", categories);
        return ResponseEntity.ok(book);
    }
}
