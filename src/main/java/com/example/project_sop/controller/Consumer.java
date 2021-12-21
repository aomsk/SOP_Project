package com.example.project_sop.controller;

import com.example.project_sop.HoldBook;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer extends HoldBook {

    @RabbitListener(queues = "HoldBook")
    public void addHoldBookTitle(String t) {
        holdBookTitle.add(t);
        System.out.println("holdBookTitle : " + holdBookTitle);
    }

    @RabbitListener(queues = "searchBookTitleQueue")
    public void searchBookTitleQueue(String searchBookTitle) {
        searchBookTitleList.add(searchBookTitle);
        System.out.println("searchBookTitle : " + searchBookTitleList);
    }

    @RabbitListener(queues = "searchBookAuthorQueue")
    public void searchBookAuthorQueue(String searchBookAuthor) {
        searchBookAuthorList.add(searchBookAuthor);
        System.out.println("searchBookAuthor : " + searchBookAuthorList);
    }

    @RabbitListener(queues = "searchBookCategoriesQueue")
    public void searchBookCategoriesQueue(String searchBookCategories) {
        searchBookCategoriesList.add(searchBookCategories);
        System.out.println("searchBookCategories : " + searchBookCategoriesList);
    }

    @RabbitListener(queues = "searchBookISBNQueue")
    public void searchBookISBNQueue(String searchBookISBN) {
        searchBookISBNList.add(searchBookISBN);
        System.out.println("searchBookISBN : " + searchBookISBNList);
    }

}
