package com.hexagonsoft.java.functionalprogramming;

public class Product {

    private final String name;
    private final Double price;

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " for " + price;
    }
}
