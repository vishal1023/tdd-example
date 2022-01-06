package com.example.tdd.service;

import com.example.tdd.exception.CarNotFoundException;
import com.example.tdd.model.Car;
import com.example.tdd.repository.CarRepository;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car getCarDetails(String name) {
        Car car = carRepository.findByName(name);

        if(car == null) {
            throw new CarNotFoundException();
        }

        return car;
    }
}
