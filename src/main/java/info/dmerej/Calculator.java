package info.dmerej;

import com.sun.jdi.InvalidTypeException;

import java.util.Stack;

public class Calculator {
    private static final String operators = "+-/*";

    public int RPNEvaluation(String expression) {
        verifyExpression(expression);

        String[] tokens = expression.split(" ");
        Stack<Integer> stack = new Stack<Integer>();

        int result = Integer.parseInt(tokens[0]);

        for (int i = 1; i < tokens.length; i++) {
            if (isInteger(tokens[i])) {
                stack.push(Integer.parseInt(tokens[i]));
            }
            else {
                if (operators.contains(tokens[i])) {
                    while (!stack.empty()) {
                        switch (tokens[i]) {
                            case "+":
                                result += stack.pop();
                                break;
                            case "-":
                                result -= stack.pop();
                                break;
                            case "/":
                                result /= stack.pop();
                                break;
                            case "*":
                                result *= stack.pop();
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
        }

        return result;
    }
 
    public boolean isInteger(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void verifyExpression(String expression) {
        String[] tokens = expression.split(" ");
        // Vérifier qu'on a bien minimum 3 arguments
        if (tokens.length < 3) {
            throw new NumberFormatException("Not enough arguments");
        }
        // Vérifier que les deux premiers sont des nombres
        else if (!isInteger(tokens[0]) || !isInteger(tokens[1])) {
            throw new ArithmeticException("Expecting two integers arguments");
        }
        // Vérifier que le 3e argument est un opérateur
        else if (!operators.contains(tokens[2])) {
            throw new ArithmeticException("Expecting an operator as the 3rd argument");
        }
        // Vérifier que tout le reste de la liste suit le modèle [int, operator]
        else {
            for (int i=3; i < tokens.length; i+=2) {
                if (!isInteger(tokens[i]) || !operators.contains(tokens[i+1])) {
                    throw new ArithmeticException("Expecting (integer, operator) pattern");
                }
            }
        }
    }

}
