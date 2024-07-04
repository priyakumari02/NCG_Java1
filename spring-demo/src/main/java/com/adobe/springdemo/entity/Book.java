package com.adobe.springdemo.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Book {
    int id;
    String title;
}
