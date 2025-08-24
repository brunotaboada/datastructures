package demo;

import java.util.*;

class BalancedBrackets {
    private final List<Character> leftBrackets = Arrays.asList('(', '[', '{', '<');
    private final List<Character> rightBrackets = Arrays.asList(')', ']', '}', '>');

    public static void main(String[] args) {
        BalancedBrackets balancedBrackets = new BalancedBrackets();
        System.out.println(balancedBrackets.balancedBrackets("[()"));
    }

    public boolean balancedBrackets(String str) {
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (isLeftBracket(ch))
                stack.push(ch);

            if (isRightBracket(ch)) {
                if (stack.empty())
                    return false;

                var top = stack.pop();
                if (!bracketsMatch(top, ch))
                    return false;
            }
        }

        return stack.empty();
    }

    private boolean isLeftBracket(char ch) {
        return leftBrackets.contains(ch);
    }

    private boolean isRightBracket(char ch) {
        return rightBrackets.contains(ch);
    }

    private boolean bracketsMatch(char left, char right) {
        return leftBrackets.indexOf(left) == rightBrackets.indexOf(right);
    }

}
