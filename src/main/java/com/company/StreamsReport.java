package com.company;

import java.util.*;
import java.util.stream.Collectors;

class Car {

    private String name;

    private List<Part> parts = new ArrayList<>();

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

        var totalByCar = cars.stream().collect(
                Collectors.groupingBy(Car::getName,
                        Collectors.mapping(c -> c.getParts().stream().mapToDouble(p-> p.getQty() * p.getPrice()).sum(),
                                Collectors.toList())));

        System.out.printf("Total USD %.2f \n", total);

        totalByCar.forEach((entry,value)->System.out.printf("Car: %s Total: %.2f \n",entry,value.get(0)));


    }

}
