import org.junit.Before;
import org.junit.Test;
import siit.Calculator;
import siit.Splitter;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {

    private Calculator calculator;
    private Splitter splitter;

    @Before
    public void setup() {
        calculator = new Calculator();
        splitter = new Splitter();
    }

    @Test
    public void testIfNumberConvertedToMmIsCorrectForEveryUnit() {
        String[] unitsOfMeasurements = {"mm", "cm", "dm", "m", "dk", "hc", "km"};

        for (int i = 0; i < unitsOfMeasurements.length; i++) {
            double result = calculator.convertUnitToMm(1, unitsOfMeasurements[i]);
            assertThat(result, is(1.0 * Math.pow(10,i)));
        }
    }

    @Test
    public void testIfTotalIsConvertedCorrectForEveryUnit() {
        String[] unitsOfMeasurements = {"mm", "cm", "dm", "m", "dk", "hc", "km"};

        for (int i = 0; i < unitsOfMeasurements.length; i++) {
            double result = calculator.convertTotal(10.0, unitsOfMeasurements[i]);
            assertThat(result, is(10 / Math.pow(10,i)));
        }
    }

    @Test
    public void testIfTotalIsCalculatedCorrectWhenPlusOperand() {
        calculator.setConvertedNumbers(10);
        calculator.setConvertedNumbers(10);
        splitter.addUnitOfMeasure("mm");
        splitter.addUnitOfMeasure("mm");
        splitter.addOperands("+");
        assertThat(20.0, is(calculator.calculateTotal()));
    }

    @Test
    public void testIfTotalIsCalculatedCorrectWhenMinusOperand() {
        calculator.setConvertedNumbers(10);
        calculator.setConvertedNumbers(10);
        splitter.addUnitOfMeasure("mm");
        splitter.addUnitOfMeasure("mm");
        splitter.addOperands("-");
        assertThat(0.0, is(calculator.calculateTotal()));
    }

    @Test
    public void testIfTotalIsCalculatedCorrectWhenBothOperand() {
        calculator.setConvertedNumbers(10);
        calculator.setConvertedNumbers(10);
        calculator.setConvertedNumbers(10);
        splitter.addUnitOfMeasure("mm");
        splitter.addUnitOfMeasure("mm");
        splitter.addUnitOfMeasure("mm");
        splitter.addOperands("-");
        splitter.addOperands("+");
        assertThat(20.0, is(calculator.calculateTotal()));
    }
}
