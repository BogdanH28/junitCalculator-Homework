package siit;

import java.util.ArrayList;
import java.util.List;

public class Splitter {

    private static String[] unitsOfMeasurements = {"mm", "cm", "dm", "m", "dk", "hc", "km"};
    private static List<Integer> numbers = new ArrayList<>();
    private static List<String> unitsOfMeasure = new ArrayList<>();
    private static List<String> operands = new ArrayList<>();

    public int getOperandsListSize() {
        return operands.size();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public List<String> getUnitsOfMeasure() {
        return unitsOfMeasure;
    }

    public List<String> getOperands() {
        return operands;
    }

    //    Adds number from expression to "numbers" arrayList
    public void addNumberToArrayList(String expression) {

        String[] integerStrings = expression.split(" ");
        int[] integers = new int[integerStrings.length];

        for (int i = 0; i < integerStrings.length; i++) {
            if(integerStrings[i].charAt(0) >= '0' && integerStrings[i].charAt(0) <= '9') {
                integers[i] = Integer.parseInt(integerStrings[i]);
                numbers.add(integers[i]);
            }
        }
    }

//    Adds units of measurement from expression to "unitsOfMeasure" arrayList
    public void addUnitOfMeasure(String expression) {
        String[] allStrings = expression.split(" ");

        for (int i = 0; i < allStrings.length; i++) {
            if(allStrings[i].contains("mm") || allStrings[i].contains("cm") || allStrings[i].contains("dm") || allStrings[i].contains("m")
                    || allStrings[i].contains("km")) {
                unitsOfMeasure.add(allStrings[i]);
            }
        }
    }

//    Adds operands from expression to "operands" arrayList
    public void addOperands(String expression) {
        String[] allStrings = expression.split(" ");

        for (int i = 0; i < allStrings.length; i++) {
            if (allStrings[i].equals("+") || allStrings[i].equals("-")) {
                operands.add(allStrings[i]);
            }
        }
    }
}
