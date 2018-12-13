package siit;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Expression ex = new Expression();
        String expression = ex.getExpression();

//        Split expression in numbers, units and operands
        Splitter s = new Splitter();
        s.addNumberToArrayList(expression);
        s.addUnitOfMeasure(expression);
        s.addOperands(expression);

//        Convert all numbers to mm
        Calculator c = new Calculator();
        c.addConvertedNumbers();

//        Request wanted unit, calculate total and convert it
        double total = c.calculateTotal();
        double result = getRequiredUnit(total, c);
        printResult(result);
    }

    public static double getRequiredUnit(double total, Calculator c) {
        System.out.println("In what unit you want the result?");
        Scanner in = new Scanner(System.in);
        String resultUnit = in.next();
        return c.convertTotal(total, resultUnit);
    }

    public static void printResult( double result) {
        System.out.println(result);
    }
}
