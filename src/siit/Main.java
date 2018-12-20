package siit;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        StatisticsRepository repo = new StatisticsRepository();

//        Start main ct
        ComputingTime ct_main = new ComputingTime("Main");
        ct_main.setStartTime(System.nanoTime());

        Expression ex = new Expression();

//        Start expression ct
        ComputingTime ct_expression = new ComputingTime("getExpression");
        ct_expression.setStartTime(System.nanoTime());
        String expression = ex.getExpression();
        ct_expression.setStopTime(System.nanoTime());
//        Stop expression ct

//        Split expression in numbers, units and operands
        Splitter s = new Splitter();
//        Start addNumbers ct
        ComputingTime ct_addNumbers = new ComputingTime("addNumberToArrayList");
        ct_addNumbers.setStartTime(System.nanoTime());
        s.addNumberToArrayList(expression);
        ct_addNumbers.setStopTime(System.nanoTime());
//        Stop addNumbers ct

//        Start addUnits ct
        ComputingTime ct_addUnits = new ComputingTime("addUnitOfMeasure");
        ct_addUnits.setStartTime(System.nanoTime());
        s.addUnitOfMeasure(expression);
        ct_addUnits.setStopTime(System.nanoTime());
//        Stop addUnits ct

//        Start addOperands ct
        ComputingTime ct_addOperands = new ComputingTime("addUnitOfMeasure");
        ct_addOperands.setStartTime(System.nanoTime());
        s.addOperands(expression);
        ct_addOperands.setStopTime(System.nanoTime());
//        Stop addOperands

//        Convert all numbers to mm
        Calculator c = new Calculator();
//        Start addCN ct
        ComputingTime ct_addCN = new ComputingTime("addConvertedNumbers");
        ct_addCN.setStartTime(System.nanoTime());
        c.addConvertedNumbers();
        ct_addCN.setStopTime(System.nanoTime());
//        Stop addCN ct

//        Request wanted unit, calculate total and convert it

//        Start calculateTotal ct
        ComputingTime ct_calculateTotal = new ComputingTime("calculateTotal");
        ct_calculateTotal.setStartTime(System.nanoTime());
        double total = c.calculateTotal();
        ct_calculateTotal.setStopTime(System.nanoTime());
//        Stop calculateTotal ct

//        Start getRequiredUnit ct
        ComputingTime ct_getRequiredUnit = new ComputingTime("calculateTotal");
        ct_getRequiredUnit.setStartTime(System.nanoTime());
        double result = getRequiredUnit(total, c);
        ct_getRequiredUnit.setStopTime(System.nanoTime());
//        Stop getRequiredUnit ct

//        Start printResult ct
        ComputingTime ct_printResult = new ComputingTime("printResult");
        ct_printResult.setStartTime(System.nanoTime());
        printResult(result);
        ct_printResult.setStopTime(System.nanoTime());
//        Stop printResult ct


        ct_main.setStopTime(System.nanoTime());
//        Stop main ct

//        Adding computingTimes to repo
        addAllComputingTimes(repo, ct_main, ct_expression, ct_addNumbers, ct_addUnits, ct_addOperands, ct_addCN, ct_calculateTotal, ct_getRequiredUnit, ct_printResult);
        printAllComputingTimes(repo);
    }

    public static double getRequiredUnit(double total, Calculator c) {
        System.out.println("In what unit you want the result?");
        Scanner in = new Scanner(System.in);
        String resultUnit = in.next();
        return c.convertTotal(total, resultUnit);
    }

    public static void printResult(double result) {
        System.out.println(result);
    }

    public static void addAllComputingTimes(StatisticsRepository repo, ComputingTime ct_main, ComputingTime ct_expression, ComputingTime ct_addNumbers,
                                            ComputingTime ct_addUnits, ComputingTime ct_addOperands, ComputingTime ct_addCN, ComputingTime ct_calculateTotal,
                                            ComputingTime ct_getRequiredUnit, ComputingTime ct_printResult) {
        repo.addComputingTime(ct_main);
        repo.addComputingTime(ct_expression);
        repo.addComputingTime(ct_addNumbers);
        repo.addComputingTime(ct_addUnits);
        repo.addComputingTime(ct_addOperands);
        repo.addComputingTime(ct_addCN);
        repo.addComputingTime(ct_calculateTotal);
        repo.addComputingTime(ct_getRequiredUnit);
        repo.addComputingTime(ct_printResult);
    }

    public static void printAllComputingTimes(StatisticsRepository repo) {
        repo.getComputingTimes();
    }

}
