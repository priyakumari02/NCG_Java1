package com.adobe.springdemo.service;

import com.adobe.springdemo.dao.BookDao;
import com.adobe.springdemo.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AppService {
    @Autowired
    private BookDao bookDao;

    public void insertBook(Book b) {
        this.bookDao.addBook(b);
    }
}
