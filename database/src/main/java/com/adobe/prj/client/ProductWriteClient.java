package com.adobe.prj.client;

import com.adobe.prj.dao.DaoException;
import com.adobe.prj.dao.ProductDao;
import com.adobe.prj.dao.ProductDaoJdbcImpl;
import com.adobe.prj.entity.Product;

public class ProductWriteClient {
    public static void main(String[] args) {
        Product p = Product.builder()
                .id(1)
                .name("LG AC")
                .price(45000.00)
                .quantity(100)
                .build();
        ProductDao productDao = new ProductDaoJdbcImpl();
        try {
            productDao.addProduct(p);
            System.out.println("product added!!");
        } catch (DaoException e) {
//            System.out.println(e.getMessage()); // production code
            e.printStackTrace(); // development mode
        }

    }
}
