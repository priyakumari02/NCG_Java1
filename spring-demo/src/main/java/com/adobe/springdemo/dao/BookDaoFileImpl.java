package com.adobe.springdemo.dao;

import com.adobe.springdemo.entity.Book;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("dev")
public class BookDaoFileImpl implements BookDao{
    @Override
    public void addBook(Book book) {
        System.out.println(book.getTitle() + " stored in file!!!");
    }
}
