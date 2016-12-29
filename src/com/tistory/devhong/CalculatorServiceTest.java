package com.tistory.devhong;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by devHong on 2016-12-29.
 * https://github.com/sungjaeHong
 */
public class CalculatorServiceTest {

    @Test
    public void testCalculateAddition() throws Exception {
        /*
        CalculatorService calculatorService = new CalculatorService();
        int actual = calculatorService.calculate('+', 1, 1);
        assertEquals(actual,2);
        */
        Calculation calculation = new Addition();
        int actual = calculation.calculate(1, 1);
        assertEquals(actual,2);
    }

    @Test
    public void testCalculateSubtraction() throws Exception {
        /*
        CalculatorService calculatorService = new CalculatorService();
        int actual = calculatorService.calculate('-', 1, 1);
        assertEquals(actual,0);
        */
        Calculation calculation = new Subtraction();
        int actual = calculation.calculate(1, 1);
        assertEquals(actual,0);
    }

    @Test
    public void testCalculateMultiplication() throws Exception {
        /*
        CalculatorService calculatorService = new CalculatorService();
        int actual = calculatorService.calculate('*', 1, 1);
        assertEquals(actual,1);
        */
        Calculation calculation = new Multiplication();
        int actual = calculation.calculate(3, 1);
        assertEquals(actual,3);
    }

    @Test
    public void testCalculateDivision() throws Exception {
        /*
        CalculatorService calculatorService = new CalculatorService();
        int actual = calculatorService.calculate('/', 8, 4);
        assertEquals(actual,2);
        */

        Calculation calculation = new Division();
        int actual = calculation.calculate(8, 2);
        assertEquals(actual,4);
    }

}