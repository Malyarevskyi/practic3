package practic.practic3;

import java.util.LinkedList;
import java.util.Scanner;

public class Dzpractic3_3_PostfixPolishNotation {

    public static final String[] operators = {"+", "-", "*", "/"};

    public static Boolean isOperator(String mark) {
        for (String symbol : operators) {
            if (symbol.equals(mark)) {
                return true;
            }
        }
        return false;
    }

    public static int operation(String symbol, int firstValue, int secondValue) {
        if (symbol.equals("+")) {
            return firstValue + secondValue;
        } else if (symbol.equals("-")) {
            return secondValue - firstValue;
        } else if (symbol.equals("*")) {
            return firstValue * secondValue;
        } else if (symbol.equals("/")) {
            return secondValue / firstValue;
        } else {
            throw new IllegalArgumentException("Invalid operator!");
        }
    }

    public static int count(String[] signs) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (String sign : signs) {
            if (isOperator(sign)) {
                stack.push(operation(sign, stack.pop(), stack.pop()));
            } else {
                stack.push(Integer.parseInt(sign));
            }
        }
        return stack.pop();
    }

    public static void main(String args[]) {
        System.out.println("Enter the postfix polish notation ");
        Scanner sc = new Scanner(System.in);
        String function = sc.nextLine();
        System.out.println("Result after calculate = " + count(function.split(" ")));
    }
}
