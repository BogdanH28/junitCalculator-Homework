package siit;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import siit.Calculator;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
public class ParameterizedCalculatorTest {

    private Calculator calculator;
    private Double inputNumber;
    private Double expectedNumber;

    @Before
    public void setup() {
        calculator = new Calculator();
    }

    public ParameterizedCalculatorTest(Double inputNumber, Double expectedNumber) {
        this.inputNumber = inputNumber;
        this.expectedNumber = expectedNumber;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
//            mm -> cm, 10 -> 1, 100 -> 10
            {10.0, 1.0},
            {100.0, 10.0}
        });
    }

    @Test
    public void testConvertTotalCm() {
        System.out.println("Parameterized Number is : " + inputNumber);
        assertEquals(expectedNumber, calculator.convertTotal(inputNumber, "cm"));
    }
}
