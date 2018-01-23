package com.hexagonsoft.java.functionalprogramming;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.hexagonsoft.java.functionalprogramming.TestData.shop;

public class CollectionExerciseMain {

    public static void main(String[] args) {

        Set<Customer> customerSet = shop.getCustomers().stream()
                .collect(Collectors.toSet());
        System.out.println(customerSet);

        //Return set of cities the customers are from
        Set<City> customerCity = shop.getCustomers()
                .stream()
                .map(customer -> customer.getCity())
                .collect(Collectors.toSet());

        System.out.println(customerCity);

        //Return a list of the customers who live in a given city
        String cityName = "Tokyo";
        Set<Customer> customersInACity = shop.getCustomers()
                .stream()
                .filter(customer -> customer.getCity().getName().equals(cityName))
                .collect(Collectors.toSet());

        System.out.println(customersInACity);

        //Return true if all customers are from the given city
        boolean areAllFromCity = shop.getCustomers()
                .stream()
                .allMatch(customer -> customer.getCity().getName().equals(cityName));

        System.out.println(areAllFromCity);

        //Return true if there is at least one customer from given city
        boolean isAtLeastOneFrom = shop.getCustomers()
                .stream()
                .anyMatch(customer -> customer.getCity().getName().equals(cityName));

        System.out.println(isAtLeastOneFrom);

        //Retun the number of customers from the given city
        long liveInACity = shop.getCustomers()
                .stream()
                .filter(customer -> customer.getCity().getName().equals(cityName))
                .count();

        System.out.println(liveInACity);

        //Return a customer who lives in the given city or null if there is none
        Customer customerInACIty = shop.getCustomers()
                .stream()
                .filter(customer1 -> customer1.getCity().getName().equals(cityName))
                .findFirst()
                .orElse(null);

        System.out.println(customerInACIty);

        //
        Set<String> allCustomerNames = shop.getCustomers()
                .stream()
                .map(customer -> customer.getName())
                .collect(Collectors.toSet());

        //Return all orders
        Set<Order> allOrders = shop.getCustomers()
                .stream()
                .map(customer -> customer.getOrders())
                .flatMap(orders -> orders.stream())
                .collect(Collectors.toSet());

        System.out.println(allOrders);

        //Return all products
        Set<Product> orderedProducts = shop.getCustomers()
                .stream()
//                .map(customer -> customer.getOrders())
//                .flatMap(orders -> orders.stream())
//                .map(order -> order.getProducts())
//                .flatMap(products -> products.stream())
                .map(Customer::getOrders)
                .flatMap(Collection::stream)
                .map(Order::getProducts)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());

        System.out.println(orderedProducts);

        //Return the customer whose order count is the highest among all customers

        Customer customerMostOrders = shop.getCustomers()
                .stream()
                .max(Comparator.comparingInt(customer -> customer.getOrders().size()))
                .orElseThrow(RuntimeException::new);

        System.out.println(customerMostOrders);

        //Return the most expensive product which has been ordered
        Product mostExpensive = customerMostOrders.getOrders()
                .stream()
                .map(Order::getProducts)
                .flatMap(Collection::stream)
                .max(Comparator.comparingDouble(Product::getPrice))
//                .orElseThrow(() -> new RuntimeException());
                .orElseThrow(RuntimeException::new);

        System.out.println(mostExpensive);

        //Return a list of customers sorted by the ascending number of orders tey made
        List<Customer> customersAscending = shop.getCustomers()
                .stream()
                .sorted(Comparator.comparingInt(customer -> customer.getOrders().size()))
                .collect(Collectors.toList());

        System.out.println(customersAscending);

        //Return the sum of prices of all products that a customer has ordered
        double sumOfPrices = customerMostOrders.getOrders()
                .stream()
                .map(Order::getProducts)
                .flatMap(Collection::stream)
                .mapToDouble(Product::getPrice)
                .sum();

        System.out.println(sumOfPrices);

        //Return a map of customers by city
        Map<City, List<Customer>> customersByCity = shop.getCustomers()
                .stream()
                .collect(Collectors.groupingBy(Customer::getCity, Collectors.toList()));

        System.out.println(customersByCity);

        //Map<CIty, Integer> liczba customerow w miesice
        Map<City, Long> numberOfCustomersInCity = shop.getCustomers()
                .stream()
                .collect(Collectors.groupingBy(Customer::getCity, Collectors.counting()));

        System.out.println(numberOfCustomersInCity);

        Stream<Customer> customerStream = shop.getCustomers()
                .stream().distinct();
        Optional<Customer> customer = customerStream.findFirst();

        System.out.println(customer);

        shop.getCustomers().stream()
                .map(customer1 -> {
                    System.out.println("sad");
                    return customer1;
                });
    }
}
