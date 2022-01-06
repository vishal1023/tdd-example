package com.example.tdd.api;

import com.example.tdd.model.Car;
import com.example.tdd.service.CarService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * This is different from the Integration test. It doesn't start entire application.
 * It just start the app with the controller we are trying to test. In this case we are trying to test the car controller.
 *
 * you can specify the controller in the @WebMvcTest with controllers
 */

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = CarController.class)
public class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarService carService;

    @Test
    void getCar_shouldReturnCarDetails() throws Exception {
        given(carService.getCarDetails(anyString())).willReturn(new Car("bmw", "hybrid"));

        mockMvc.perform(MockMvcRequestBuilders.get("/cars/bmw"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("bmw"))
                .andExpect(jsonPath("type").value("hybrid"));
    }
}
