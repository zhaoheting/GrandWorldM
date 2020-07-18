package web.services.learn;

import com.alibaba.druid.sql.visitor.functions.Char;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Infix to postfix conversion.
 */
public class PostfixConversion {

    public static void main(String[] args) {
        String infix = "a+b*c+(d*e+f)*g";
        List<Character> result = convert(infix);
        for (char c : result) {
            System.out.print(c + " ");
        }
    }

    public static List<Character> convert(String infix) {
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
