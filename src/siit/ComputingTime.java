package siit;

public class ComputingTime {

    private long startTime;
    private long stopTime;
    private String methodName;

    public ComputingTime(String methodName) {
        this.methodName = methodName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public void setStopTime(long stopTime) {
        this.stopTime = stopTime;
    }

    public long getTotalComputingTime() {
        return (this.stopTime-this.startTime) / 1000000000;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getStopTime() {
        return stopTime;
    }
}
