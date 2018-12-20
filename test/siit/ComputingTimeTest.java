package siit;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ComputingTimeTest {

    private ComputingTime computingTime;

    @Before
    public void setup() {
        computingTime = new ComputingTime("Method");
    }

    @Test
    public void checkSetStartingTimeWorksProperly() {
        computingTime.setStartTime(0);
        assertThat(computingTime.getStartTime(), is(0L));
    }

    @Test
    public void checkSetStopTimeWorksProperly() {
        computingTime.setStopTime(5);
        assertThat(computingTime.getStopTime(), is(5L));
    }

    @Test
    public void checkGetCorrectMethodName() {
        assertThat(computingTime.getMethodName(), is("Method"));
    }

    @Test
    public void checkTotalIsCalculatedCorrectly() {
        computingTime.setStartTime(1000000000);
        computingTime.setStopTime(2000000000);
        assertThat(computingTime.getTotalComputingTime(), is(1L));
    }
}
