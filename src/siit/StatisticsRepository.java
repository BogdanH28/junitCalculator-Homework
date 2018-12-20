package siit;

import java.util.ArrayList;
import java.util.List;

public class StatisticsRepository {

    private List<ComputingTime> computingTimes = new ArrayList<>();

    public void addComputingTime(ComputingTime ct) {
        computingTimes.add(ct);
    }

    public void getComputingTimes() {
        for (ComputingTime ct: computingTimes) {
            System.out.println(ct.getMethodName() + " " + ct.getTotalComputingTime() + " seconds");
        }
    }
}
