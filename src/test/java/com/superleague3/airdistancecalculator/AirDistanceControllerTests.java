package com.superleague3.airdistancecalculator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.superleague3.airdistancecalculator.DistanceCalculation.Haversine;
import com.superleague3.airdistancecalculator.POJOs.Coordinates;
import com.superleague3.airdistancecalculator.POJOs.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
public class AirDistanceControllerTests {

    @MockBean
    private Haversine haversine; // Mocking the Haversine dependency

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testGetDistance() throws Exception {
        // Given
        Coordinates coords = new Coordinates(new Location(43.0721661, -89.4007501), new Location(47.7510741, -120.7401386));
        double expectedDistance = 2483.0072587651935; // Replace with your expected distance value

//        // Mock the behavior of Haversine
//        when(haversine.getDistance(43.0721661, -89.4007501, 47.7510741, -120.7401386))
//                .thenReturn(expectedDistance);

        // When-Then
        mockMvc.perform(MockMvcRequestBuilders.post("/getDistance")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(coords)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(String.valueOf(expectedDistance)));
    }
}
