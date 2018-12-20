package siit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        CalculatorTest.class,
        ExpressionTest.class,
        ParameterizedCalculatorTest.class,
        SplitterTest.class,
        ComputingTimeTest.class
})

public class SuiteTest {
}
