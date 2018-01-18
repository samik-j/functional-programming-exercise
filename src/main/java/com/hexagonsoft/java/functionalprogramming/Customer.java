package com.hexagonsoft.java.functionalprogramming;

import java.util.List;

public class Customer {

    private final String name;
    private final City city;
    private final List<Order> orders;

    public Customer(String name, City city, List<Order> orders) {
        this.name = name;
        this.city = city;
        this.orders = orders;
    }

}
