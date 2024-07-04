package com.adobe.springdemo.dao;

import com.adobe.springdemo.entity.Book;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("prod")
public class BookDaoJdbcImpl implements  BookDao{
    @Override
    public void addBook(Book book) {
        System.out.println(book.getTitle() + " stored in RDBMS!!!");
    }
}
