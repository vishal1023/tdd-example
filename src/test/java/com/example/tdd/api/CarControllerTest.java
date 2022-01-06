package com.example.tdd.api;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

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

    @Test
    void getCar_shouldReturnCarDetails() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/cars/bmw"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("bmw"))
                .andExpect(jsonPath("type").value("hybrid"));
    }
}
