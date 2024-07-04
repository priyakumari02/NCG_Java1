package com.adobe.springdemo.dao;

import com.adobe.springdemo.entity.Book;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoJdbcImpl implements  BookDao{
    @Override
    public void addBook(Book book) {
        System.out.println(book.getTitle() + " stored in RDBMS!!!");
    }
}
