package com.hexagonsoft.java.functionalprogramming;

import java.util.Optional;

public class OptionalExampleExercise {

    public static void main(String[] args) {

        String animalFound = findAnimal().orElseThrow(() -> new SomeException());

        System.out.println(animalFound);

        Optional<String> sth = Optional.of("a");
        sth.ifPresent(System.out::println);

        Optional<Color> color = Optional.of(new Color("red"));
        color.ifPresent(color1 -> {char a = color1.toString().charAt(0); System.out.println(a);});
        color.ifPresent(System.out::println);

        Optional<Color> color1 = Optional.empty();
        Color some = color1.orElse(new Color("default"));
        System.out.println(some);

        Optional<Color> maybeRed = Optional.of(getColor());
        maybeRed.filter(maybe -> maybe.name.equals("red"))
                .ifPresent(red -> System.out.println("is " + red.name));
    }

    static Color getColor() {
        return new Color("red");
    }

    static Optional<String> findAnimal() {
        return Optional.of("lion");
    }
}
