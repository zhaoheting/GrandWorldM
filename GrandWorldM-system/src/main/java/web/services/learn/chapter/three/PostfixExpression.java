package web.services.learn.chapter.three;

import java.util.List;
import java.util.Stack;

/**
 * Calculate postfix expression.
 */
public class PostfixExpression {

    private Stack<Double> expressions;

    public PostfixExpression() {
        this.expressions = new Stack<>();
    }

    public double getResult() {
        checkExpression();
        return expressions.pop();
    }

    private void checkExpression() {
        if (expressions.size() != 1) {
            throw new RuntimeException("The expression has errors, please check it.");
        }
    }

    public void add(double number) {
        this.expressions.push(number);
    }

    public void add(FOUR_FUNCTIONS symbol) {
        double firstElement = this.expressions.pop();
        double secondElement = this.expressions.pop();
        if (FOUR_FUNCTIONS.DIVIDE.equals(symbol) && secondElement == 0) {
            throw new ArithmeticException();
        }
        double result = 0;
        switch (symbol) {
            case ADD:
                result = firstElement + secondElement;
                break;
            case MINUS:
                result = firstElement - secondElement;
                break;
            case DIVIDE:
                result = firstElement / secondElement;
                break;
            case MULTIPLY:
                result = firstElement * secondElement;
        }
        expressions.push(result);
    }

    public enum FOUR_FUNCTIONS {

        ADD('+'),
        MINUS('-'),
        MULTIPLY('*'),
        DIVIDE('/');

        private char symbol;

        FOUR_FUNCTIONS(char symbol) {
            this.symbol = symbol;
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }

    public static void main(String[] args) {
        //Add a postfix directly.
        PostfixExpression postfixExpression = new PostfixExpression();
        postfixExpression.add(6);
        postfixExpression.add(5);
        postfixExpression.add(2);
        postfixExpression.add(3);
        postfixExpression.add(PostfixExpression.FOUR_FUNCTIONS.ADD);
        postfixExpression.add(8);
        postfixExpression.add(PostfixExpression.FOUR_FUNCTIONS.MULTIPLY);
        postfixExpression.add(PostfixExpression.FOUR_FUNCTIONS.ADD);
        postfixExpression.add(3);
        postfixExpression.add(PostfixExpression.FOUR_FUNCTIONS.ADD);
        postfixExpression.add(PostfixExpression.FOUR_FUNCTIONS.MULTIPLY);
        double result = postfixExpression.getResult();
        System.out.println(result);

        // Convert a expression into postfix firstly and then calculate it.
        String infix = "9-3-1+2*2+(3/2+2)";
        List<Character> postfix = PostfixConversion.convertNumber(infix);
        double result2 = calculateByPostfix(postfix);
        System.out.println(result2);

    }

    private static double calculateByPostfix(List<Character> postfix) {
        Stack<Double> stack = new Stack<>();
        int result = 0;
        postfix.forEach(x -> {
            if (Character.isDigit(x)) {
                stack.push(x - 48d);
            } else {
                double param2 = stack.pop(), param1 = stack.pop();
                double current = calculate(param1, param2, x);
                stack.push(current);
            }
        });
        return stack.pop();
    }

    private static double calculate(double param1, double param2, char operator) {
        switch (operator) {
            case '+':
                return param1 + param2;
            case '-':
                return param1 - param2;
            case '*':
                return param1 * param2;
            case '/':
                return param1 / param2;
            default:
                break;
        }
        return 0;
    }
}
