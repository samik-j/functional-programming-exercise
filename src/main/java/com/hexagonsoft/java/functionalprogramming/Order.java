package com.hexagonsoft.java.functionalprogramming;

import java.util.List;

public class Order {

    private final List<Product> products;
    private final boolean delivered;

    public Order(List<Product> products, boolean delivered) {
        this.products = products;
        this.delivered = delivered;
    }

    public List<Product> getProducts() {
        return products;
    }

    public boolean isDelivered() {
        return delivered;
    }

    @Override
    public String toString() {
        return "Order{" +
                "products=" + products +
                ", delivered=" + delivered +
                '}';
    }
}
