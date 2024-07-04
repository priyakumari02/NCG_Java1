package com.adobe.prj.dao;

import com.adobe.prj.entity.Product;

import java.util.List;

/**
 * Interface for CRUD operations on Product entity
 *
 * @author banuprakash
 * @version  1.0.0
 */
public interface ProductDao {
    /**
     * method to insert product into datastore
     *
     * @param p product
     * @throws DaoException
     */
    void addProduct(Product p) throws DaoException;

    /**
     * method to fetch all products
     *
     * @return all products
     * @throws DaoException
     */
    List<Product> getProducts() throws DaoException;

    /**
     * Fetch product by ID.
     *
     * @param id id of product to be fetched
     * @return product for the given id
     * @throws DaoException
     */
    Product getProduct(int id) throws DaoException;
}
