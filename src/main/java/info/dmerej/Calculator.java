package info.dmerej;

import java.util.Stack;

public class Calculator {
    // private static final String operators = "+-/*";

    public int RPNEvaluation(String expression) {
        String[] tokens = expression.split(" ");
        Stack<Integer> stack = new Stack<Integer>();

        int result = 0;

        for (String token : tokens) {
            if (isInteger(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                while (!stack.empty()) {
                    result += stack.pop();
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
}
