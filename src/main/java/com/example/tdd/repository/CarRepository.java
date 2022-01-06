package com.example.tdd.repository;

import com.example.tdd.model.Car;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CarRepository {

    private final Map<String, Car> cars;

    public CarRepository() {
        this.cars = new HashMap<>();
        initCarMapping(cars);
    }

    private void initCarMapping(Map<String, Car> cars) {
        cars.put("bmw", new Car("bmw", "hybrid"));
        cars.put("volkswagen", new Car("volkswagen", "petrol"));
        cars.put("audi", new Car("audi", "diesel"));
    }

    public Car findByName(String name) {
        return cars.get(name);
    }
}
