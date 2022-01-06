package com.example.tdd.api;

import com.example.tdd.model.Car;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    @GetMapping("/cars/{name}")
    public Car getCar(@PathVariable String name) {
        return null;
    }
}
