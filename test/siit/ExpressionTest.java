package siit;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.fail;

public class ExpressionTest {

    private Expression expression;
    private Splitter splitter;

    @Before
    public void setup() {
        expression = new Expression();
    }

    @Test
    public void testIfExpressionIsEmpty() {
        if (expression.getExpression().length() == 0) {
            fail("The expression can't be empty!");
        }
    }
}
