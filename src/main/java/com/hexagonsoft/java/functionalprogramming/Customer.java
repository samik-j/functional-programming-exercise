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

    public String getName() {
        return name;
    }

    public City getCity() {
        return city;
    }

    public List<Order> getOrders() {
        return orders;
    }

    void printOrders() {
        orders.stream()
                .forEach(order -> printOrder(order));
    }

    private void printOrder(Order order) {
        System.out.println(order);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", city=" + city +
                ", orders=" + orders +
                '}';
    }
}
