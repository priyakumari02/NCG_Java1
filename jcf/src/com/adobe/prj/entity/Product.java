package com.adobe.prj.entity;

import java.util.Objects;

public class Product implements  Comparable<Product>{
    private int id;
    private String name;
    private double price;
    private String category;

    public Product() {
    }

    public Product(int id, String name, double price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && Double.compare(price, product.price) == 0 && Objects.equals(name, product.name) && Objects.equals(category, product.category);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public int compareTo(Product o) {
        return this.id - o.id;
    }

    @Override
    public String toString() {
        return id +" , " + name +", " + price +", " + category;
    }
}
