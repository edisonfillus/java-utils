package com.company;

import java.text.NumberFormat;
import java.util.*;
import java.util.stream.Collectors;

class Car {

    private final String name;

    private final List<Part> parts = new ArrayList<>();

    public Car(String name) {
        this.name = name;
    }

    public List<Part> getParts() {
        return Collections.unmodifiableList(parts);
    }

    public void addPart(Part part) {
        this.parts.add(part);
    }

    public String getName() {
        return name;
    }
}

class Part {
    double price;
    int qty;

    public Part(double price, int qty) {
        this.price = price;
        this.qty = qty;
    }

    public int getQty() {
        return qty;
    }

    public double getPrice() {
        return price;
    }
}

public class StreamsReport {

    public static void main(String... args) {

        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.US);

        var car1 = new Car("x20");
        car1.addPart(new Part(100.0, 2));
        car1.addPart(new Part(25.0, 1));

        var car2 = new Car("x10");
        car2.addPart(new Part(50.0, 3));
        car2.addPart(new Part(30.0, 2));

        var cars = List.of(car1, car2);

        var total = cars.stream()
                .flatMap(c -> c.getParts().stream())
                .mapToDouble(p -> p.getQty() * p.getPrice())
                .sum();

        var totalByCar = cars.stream()
                .collect(
                        Collectors.groupingBy(
                                Car::getName,
                                Collectors.mapping(
                                        c -> c.getParts().stream()
                                                .mapToDouble(p -> p.getQty() * p.getPrice())
                                                .sum(),
                                        Collectors.toList()
                                )
                        )
                );

        var totalByCarFormatted = cars.stream()
                .collect(
                        Collectors.groupingBy(
                                Car::getName,
                                Collectors.collectingAndThen(
                                        Collectors.summingDouble(
                                                c -> c.getParts().stream()
                                                        .mapToDouble(p -> p.getQty() * p.getPrice())
                                                        .sum()
                                        ),
                                        currencyFormatter::format
                                )
                        )
                );

        System.out.printf("Total USD %.2f \n", total);

        System.out.println(totalByCar);

        totalByCarFormatted.forEach((car, value) -> System.out.printf("Car: %s Total: %s \n", car, value));


    }

}
