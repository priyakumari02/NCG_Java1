package com.adobe.springdemo.dao;

import com.adobe.springdemo.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;

@Repository
@Profile("prod")
public class BookDaoJdbcImpl implements  BookDao{
    @Autowired
    DataSource ds;
    @Override
    public void addBook(Book book) {
//        Connection con = ds.getConnection();
        System.out.println(book.getTitle() + " stored in RDBMS!!!");
    }
}
