package com.adobe.prj.dao;

import com.adobe.prj.entity.Product;

import java.util.List;

public interface ProductDao {
    void addProduct(Product p) throws DaoException;
    List<Product> getProducts() throws DaoException;
    Product getProduct(int id) throws DaoException;
}
