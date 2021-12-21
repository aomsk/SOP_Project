package com.example.project_sop.repository;

import com.example.project_sop.pojo.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {

    @Query(value = "{title:'?0'}")
    public Book findBookByTitle(String title);

    @Query(value = "{isbn:?0}")
    public Book findBookByIsbn(String isbn);

    @Query(value = "{_id:?0}")
    public Book findBookByID(Integer _id);

    @Query(value = "{ 'authors' : { $all: ['?0'] } }")
    public List<Book> findBookByAuthor(String authors);

    @Query(value = "{ 'categories' : { $all: ['?0'] } }")
    public List<Book> findBookByCategories(String categories);
}
