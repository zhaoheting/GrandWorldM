package web.services.learn;

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
    }
}
