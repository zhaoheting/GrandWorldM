package web.services.learn.chapter.three;

import java.util.Stack;

/**
 * TODO
 *
 * @author HeTing.Zhao
 * @since 2022/4/16
 */
public class BalanceSymbols {

    public static void main(String[] args) {
        String target = "([]{}({})){}";
        boolean result = new BalanceSymbols().solution(target);
        System.out.println(result);
    }

    private boolean solution(String target) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < target.length(); ++i) {
            char currentChar = target.charAt(i);
            if (currentChar == ')' || currentChar == ']' || currentChar == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                char lastCharInStack = stack.pop();
                if (!isBalance(lastCharInStack, currentChar)) {
                    return false;
                }
            } else {
                stack.push(currentChar);
            }
        }
        return stack.isEmpty();
    }

    private boolean isBalance(char left, char right) {
        if ((left == '(' && right == ')') || (left == '[' && right == ']') || (left == '{' && right == '}')) {
            return true;
        }
        return false;
    }
}
