package com.adobe.prj.client;

import com.adobe.prj.dao.DaoException;
import com.adobe.prj.dao.ProductDao;
import com.adobe.prj.dao.ProductDaoJdbcImpl;
import com.adobe.prj.entity.Product;

import java.util.List;

public class ProductReadClient {
    public static void main(String[] args) {
        ProductDao productDao = new ProductDaoJdbcImpl(); // factory

        try {
            List<Product> products = productDao.getProducts();
            for(Product p : products) {
                System.out.println(p);
            }
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }
    }
}
