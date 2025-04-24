package com.productapp.demo.cityapp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class CityApiTest {
    private CityApi cityApi;

    @BeforeEach
    void setUp() {
        cityApi=new CityApi();
    }
    @Test
    void getCity() {
        String cityName= assertTimeout(Duration.ofMillis(3000), ()->cityApi.getCity(3));
    }

    @AfterEach
    void tearDown() {
        cityApi=null;
    }


}