package com.productapp.demo.calapp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;
//20% 80%
class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator=new Calculator();
    }

    @EnabledOnOs(OS.WINDOWS)
    @EnabledOnJre(JRE.JAVA_17)
    @DisplayName("test for add two number")
    @Test
    void addTest() {
        assertEquals(2, calculator.add(1, 1));
    }

    @Test
    void mulTest() {
        assertEquals(10, calculator.mul(5, 2));
    }

    @Test
    void divideTestSuccess() {
        assertEquals(2, calculator.divide(5, 2));
    }
    @Test
    void divideTestWithException() {
       assertThrows(ArithmeticException.class,
               ()->calculator.divide(5,0),
               "divide by zero");
    }


    @AfterEach
    void tearDown() {
        calculator=null;
    }



}