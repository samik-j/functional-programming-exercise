package com.hexagonsoft.java.functionalprogramming;

import java.util.List;

public class Shop {

    private final String name;
    private final List<Customer> customers;

    public Shop(String name, List<Customer> customers) {
        this.name = name;
        this.customers = customers;
    }

}
