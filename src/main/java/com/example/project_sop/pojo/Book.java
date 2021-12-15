package com.example.project_sop.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("books")
public class Book {

    @Id
    private String _id;
    private String title;
    private String isbn;
    private Integer pageCount;
    private String thumbnailUrl;
    private String shortDescription;
    private String longDescription;
    private String status;
    private List<String> authors;
    private List<String> categories;

    public Book() {}
    public Book(String _id, String title, String isbn, Integer pageCount, String thumbnailUrl,
                String shortDescription, String longDescription, List<String> authors, List<String> categories) {
        this._id = _id;
        this.title = title;
        this.isbn = isbn;
        this.pageCount = pageCount;
        this.thumbnailUrl = thumbnailUrl;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.authors = authors;
        this.categories = categories;
    }
}
