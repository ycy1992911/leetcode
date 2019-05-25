package stack;

import java.util.Stack;

/**
 * @author yancy3@lenovo.com
 * created on 2019-05-25
 */
public class RemoveOutermostParentheses_1021 {
    String removeOuterParentheses(String input) throws InvalidParentheseStringException {
        if (input == null || input.isEmpty()) return "";

        Stack<Character> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        int start = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                stack.push(input.charAt(i));
            } else if (input.charAt(i) == ')') {
                stack.pop();
                if (stack.empty()) {
                    res.append(input, start + 1, i);
                    start = i + 1;
                }
            }
        }

        return res.toString();
    }
}
