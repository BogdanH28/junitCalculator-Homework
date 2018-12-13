package siit;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private Splitter splitter = new Splitter();

    private List<Integer> convertedNumbers = new ArrayList<>();
    private  String[] unitsOfMeasurements = {"mm", "cm", "dm", "m", "dk", "hc", "km"};

    public void setConvertedNumbers(int number) {
        convertedNumbers.add(number);
    }

    public void addConvertedNumbers() {
        for (int i = 0; i < splitter.getUnitsOfMeasure().size(); i++) {
            if (!splitter.getUnitsOfMeasure().get(i).equals("mm"))    {
                int convertedNumber = convertUnitToMm(splitter.getNumbers().get(i), splitter.getUnitsOfMeasure().get(i));
                convertedNumbers.add(convertedNumber);
            } else {
                convertedNumbers.add(splitter.getNumbers().get(i));
            }
        }
    }

    public int convertUnitToMm(int number, String unit) {
        for (int i = 0; i < unitsOfMeasurements.length; i++) {
            if (!unit.equals(unitsOfMeasurements[i])) {
                number *= 10;
            } else {
                break;
            }
        }
        return number;
    }

    public double calculateTotal() {
        double total = convertedNumbers.get(0);
        for (int i = 1; i < convertedNumbers.size(); i++) {
            if (splitter.getOperands().get(i - 1).equals("+")) {
                total += convertedNumbers.get(i);
            } else if (splitter.getOperands().get(i - 1).equals("-")) {
                total -= convertedNumbers.get(i);
            }
        }
        return total;
    }

    public double convertTotal(double total, String resultUnit) {
        for (int i = 0; i < unitsOfMeasurements.length; i++) {
            if (!resultUnit.equals(unitsOfMeasurements[i])) {
                total /= 10;
            } else {
                break;
            }
        }
        return total;
    }
}
