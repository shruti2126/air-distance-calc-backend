package com.superleague3.airdistancecalculator.Controller;

import com.superleague3.airdistancecalculator.POJOs.Location;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
public class AirDistanceControllerIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetCoordinates() throws Exception {
        // Given
        String address = "1600 Amphitheatre Pkwy, Mountain View, CA 94043, USA";
        double expectedLat = 37.4223878; // Replace with your expected latitude value
        double expectedLng = -122.0841877; // Replace with your expected longitude value

        // When
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/getCoords")
                        .param("address", address)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        // Then
        assertEquals(MediaType.APPLICATION_JSON_VALUE, result.getResponse().getContentType());
        ObjectMapper mapper = new ObjectMapper();
        Location location = mapper.readValue(result.getResponse().getContentAsString(), Location.class);
        assertEquals(expectedLat, location.getLat());
        assertEquals(expectedLng, location.getLng());
    }

    @Test
    public void testGetCoordinatesWithStreet() {
        
    }
}
