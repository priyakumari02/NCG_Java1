package com.adobe.springdemo;

import com.adobe.springdemo.entity.Book;
import com.adobe.springdemo.service.AppService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDemoApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SpringDemoApplication.class, args);

        AppService service = ctx.getBean("appService", AppService.class);
        Book b = Book.builder().title("Spring in Action").build();
        service.insertBook(b);

//        String[] names = ctx.getBeanDefinitionNames();
//        for(String name: names) {
//            System.out.println(name);
//        }
    }

}
