package com.superleague3.airdistancecalculator;

import com.superleague3.airdistancecalculator.Controller.AirDistanceController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AirDistanceCalculatorApplicationTests {

    @Autowired
    private AirDistanceController controller;

    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
    }

}
