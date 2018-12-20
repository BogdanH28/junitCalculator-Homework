package siit;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class SplitterTest {

    private Splitter s;

    @Before
    public void setup() {
        s = new Splitter();
    }

    @Test
    public void testIfOperandsExceptPlusMinusAreAdded() {
        s.addOperands("+");
        s.addOperands("-");
        s.addOperands("/");
        for (String op: s.getOperands()) {
            assertTrue(op.equals("+") || op.equals("-"));
        }
    }

    @Test
    public void testIfOnlyUnitsOfMeasureCanBeAddedInUnitsArray() {
        s.addUnitOfMeasure("mm");
        s.addUnitOfMeasure("-");
        s.addUnitOfMeasure("x");
        for (String u: s.getUnitsOfMeasure()) {
            assertTrue(u.equals("mm") || u.equals("cm") || u.equals("dm") || u.equals("m") || u.equals("km"));
        }
    }

    @Test(expected = NumberFormatException.class)
    public void testIfNonIntegerNumbersCanBeAddedInNumbersArrayListThenReceiveException() {
        s.addNumberToArrayList("13.5");
    }
}
