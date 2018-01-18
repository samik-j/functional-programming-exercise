package com.hexagonsoft.java.functionalprogramming;

import java.util.Arrays;

public class TestData {

    private static Product idea = new Product("IntelliJ IDEA Ultimate", 199.0);
    private static Product reSharper = new Product("ReSharper", 149.0);
    private static Product dotTrace = new Product("DotTrace", 159.0);
    private static Product dotMemory = new Product("DotTrace", 129.0);
    private static Product dotCover = new Product("DotCover", 99.0);
    private static Product appCode = new Product("AppCode", 99.0);
    private static Product phpStorm = new Product("PhpStorm", 99.0);
    private static Product pyCharm = new Product("PyCharm", 99.0);
    private static Product rubyMine = new Product("RubyMine", 99.0);
    private static Product webStorm = new Product("WebStorm", 49.0);
    private static Product teamCity = new Product("TeamCity", 299.0);
    private static Product youTrack = new Product("YouTrack", 500.0);

    //customers
    private static String lucas = "Lucas";
    private static String cooper = "Cooper";
    private static String nathan = "Nathan";
    private static String reka = "Reka";
    private static String bajram = "Bajram";
    private static String asuka = "Asuka";

    //cities
    private static City Canberra = new City("Canberra");
    private static City Vancouver = new City("Vancouver");
    private static City Budapest = new City("Budapest");
    private static City Ankara = new City("Ankara");
    private static City Tokyo = new City("Tokyo");

    public static Shop shop;

    static {
        shop = createShop("jb test shop",
            customer(lucas, Canberra,
                order(reSharper),
                order(reSharper, dotMemory, dotTrace)
            ),
            customer(cooper, Canberra),
            customer(nathan, Vancouver,
                order(rubyMine, webStorm)
            ),
            customer(reka, Budapest,
                order(false, idea),
                order(false, idea),
                order(idea)
            ),
            customer(bajram, Ankara,
                order(reSharper)
            ),
            customer(asuka, Tokyo,
                order(idea)
            ));
    }

    static Customer customer(String name, City city, Order... orders) {
        return new Customer(name, city, Arrays.asList(orders));
    }

    static Order order(Product... products) {
        return new Order(Arrays.asList(products), true);
    }

    static Order order(boolean isDelivered, Product... products) {
        return new Order(Arrays.asList(products), isDelivered);
    }

    static Shop createShop(String name, Customer... customers) {
        return new Shop(name, Arrays.asList(customers));
    }

}
