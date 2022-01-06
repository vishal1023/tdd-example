package com.example.tdd.service;

import com.example.tdd.exception.CarNotFoundException;
import com.example.tdd.model.Car;
import com.example.tdd.repository.CarRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

/**
 * We are not using the spring framework at all in this class. It's a pure junit mockito test
 */
@ExtendWith(MockitoExtension.class)
class CarServiceTest {

    @InjectMocks
    private CarService carService;
    @Mock
    private CarRepository carRepository;

    @Test
    void getCarDetails_shouldReturnCarInfo() {
        given(carRepository.findByName("bmw")).willReturn(new Car("bmw", "hybrid"));

        Car car = carService.getCarDetails("bmw");

        assertThat(car.getName()).isEqualTo("bmw");
        assertThat(car.getType()).isEqualTo("hybrid");
    }

    @Test
    void getCarDetails_shouldThrowCarNotFoundException() {
        given(carRepository.findByName("some-car")).willReturn(null);

        assertThrows(CarNotFoundException.class, () -> carService.getCarDetails("some-car"));
    }
}