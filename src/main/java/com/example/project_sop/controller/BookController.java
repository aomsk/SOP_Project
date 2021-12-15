package com.example.project_sop.controller;

import com.example.project_sop.pojo.Book;
import com.example.project_sop.repository.BookService;
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

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public ResponseEntity<?> getBooks() {
        List<Book> books = bookService.retrieveBooks();
        return ResponseEntity.ok(books);
    }

    @RequestMapping(value = "/book/{title}", method = RequestMethod.GET)
    public ResponseEntity<?> getBookByTitle(@PathVariable("title") String title) {
        Book book = bookService.retrieveBookByTitle(title);
        return ResponseEntity.ok(book);
    }

    @RequestMapping(value = "/bookIsbn/{isbn}", method = RequestMethod.GET)
    public ResponseEntity<?> getBookByIsbn(@PathVariable("isbn") String isbn) {
        Book book = bookService.retrieveBookByIsbn(isbn);
        return ResponseEntity.ok(book);
    }

}
