package com.superleague3.airdistancecalculator.Service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HaversineUnitTest
{

    private final Haversine haversine = new Haversine();

    @Test
    public void testHaversineDistanceCalculation() {
        // Given
        double lat1 = 43.0721661;
        double lon1 = -89.4007501;
        double lat2 = 47.7510741;
        double lon2 = -120.7401386;
        double expectedDistance = 2483.0072587651935;

        // When
        double actualDistance = haversine.getDistance(lat1, lon1, lat2, lon2);

        // Then
        assertEquals(expectedDistance, actualDistance, 0.0001); // Specify a delta for double comparisons
    }

    // Add more test cases to cover different scenarios and edge cases

}

