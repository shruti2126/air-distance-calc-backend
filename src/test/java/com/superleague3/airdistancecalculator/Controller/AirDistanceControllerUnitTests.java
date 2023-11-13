package com.superleague3.airdistancecalculator.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.superleague3.airdistancecalculator.Service.Haversine;
import com.superleague3.airdistancecalculator.POJOs.Coordinates;
import com.superleague3.airdistancecalculator.POJOs.Location;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class AirDistanceControllerUnitTests {

    @MockBean
    private Haversine haversine; // Mocking the Haversine dependency
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetDistance() throws Exception {
        // Given
        Coordinates coords = new Coordinates(new Location(43.0721661, -89.4007501), new Location(47.7510741, -120.7401386));
        double expectedDistance = 2483.0072587651935;

        // When-Then
        mockMvc.perform(MockMvcRequestBuilders.post("/getDistance")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(coords)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(String.valueOf(expectedDistance)));
    }


}
