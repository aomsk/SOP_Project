package com.example.project_sop.repository;

import com.example.project_sop.pojo.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {

    @Query(value = "{title:'?0'}")
    public Book findByTitle(String title);

    @Query(value = "{isbn:?0}")
    public Book findByIsbn(String isbn);
}
