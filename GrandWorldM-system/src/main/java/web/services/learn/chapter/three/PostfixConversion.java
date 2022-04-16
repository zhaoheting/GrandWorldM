package web.services.learn.chapter.three;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Infix to postfix conversion.
 */
public class PostfixConversion {

    public static void main(String[] args) {
        String infix = "x-y-z-a+b*c+(d*e+f)*g";
        List<Character> result = convertLetter(infix);
        for (char c : result) {
            System.out.print(c + " ");
        }
    }

    public static List<Character> convertLetter(String infix) {
        Stack<Character> symbols = new Stack<>();
        List<Character> result = new ArrayList<>();
        for (char c : infix.toCharArray()) {
            if (c == '+' || c == '*' || c == '-' || c == '/' || c == '(') {
                while (!symbols.isEmpty() && getPriority(symbols.peek()) >= getPriority(c) && symbols.peek() != '(') {
                    result.add(symbols.pop());
                }
                symbols.push(c);
            } else if (c == ')') {
                while (true) {
                    char topSymbol = symbols.pop();
                    if (topSymbol == '(') {
                        break;
                    } else {
                        result.add(topSymbol);
                    }
                }
            } else {
                result.add(c);
            }
        }
        while (!symbols.isEmpty()) {
            result.add(symbols.pop());
        }
        return result;
    }


    public static List<Character> convertNumber(String expression) {
        char[] expressionArray = expression.toCharArray();
        Stack<Character> stack = new Stack<>();
        List<Character> resultList = new ArrayList<>();
        for (int i = 0; i < expression.length(); ++i) {
            if (Character.isDigit((expressionArray[i]))) {
                resultList.add(expressionArray[i]);
                continue;
            }
            if (expressionArray[i] == '+' || expressionArray[i] == '-' || expressionArray[i] == '*' || expressionArray[i] == '/' || expressionArray[i] == '(') {
                while (!stack.isEmpty() && stack.peek() != '(' && getPriority(stack.peek()) >= getPriority(expressionArray[i])) {
                    resultList.add(stack.pop());
                }
                stack.push(expressionArray[i]);
            }
            if (expressionArray[i] == ')') {
                while (stack.peek() != '(') {
                    resultList.add(stack.pop());
                }
                stack.pop();
            }
        }
        while (!stack.isEmpty()) {
            resultList.add(stack.pop());
        }
        return resultList;
    }

    private static int getPriority(char symbol) {
        switch (symbol) {
            case '+':
                return 1;
            case '-':
                return 2;
            case '*':
                return 3;
            case '/':
                return 4;
            case '(':
                return 5;
            default:
                throw new RuntimeException("Illegal operator!");
        }
    }
}
