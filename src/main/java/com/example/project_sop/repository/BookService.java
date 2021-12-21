package com.example.project_sop.repository;

import com.example.project_sop.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<Book> retrieveBooks() {
        return repository.findAll();
    }

    public Book retrieveBookByTitle(String title) {
        return repository.findBookByTitle(title);
    }

    public Book retrieveBookByIsbn(String isbn) {
        return repository.findBookByIsbn(isbn);
    }

    public Book retrieveBookById(Integer _id) {
        return repository.findBookByID(_id);
    }

    public List<Book> retrieveBookByAuthor(String authors) {
        return repository.findBookByAuthor(authors);
    }

    public List<Book> retrieveBookByCategories(String categories) {
        return repository.findBookByCategories(categories);
    }
}
