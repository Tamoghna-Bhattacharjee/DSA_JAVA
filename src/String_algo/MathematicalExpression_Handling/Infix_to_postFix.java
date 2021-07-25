package String_algo.MathematicalExpression_Handling;

import java.util.Stack;

public class Infix_to_postFix {
    public static void main(String[] args) {
        //Scanner scan = new Scanner(System.in);
        String s = "a+b*(c^d-e)^(f+g*h)-i";
        Stack<Character> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z')) builder.append(ch);
            else if (ch == '(') stack.push(ch);
            else if (ch == ')') {
                while (stack.peek() != '(') {
                    builder.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.empty() && getPriority(stack.peek()) >= getPriority(ch))
                    builder.append(stack.pop());
                stack.push(ch);
            }
            i++;
        }
        while (!stack.empty()) builder.append(stack.pop());
        System.out.println(builder.toString());
    }
    public static int getPriority(char ch) {
        if (ch == '^') return 3;
        else if (ch == '*' || ch == '/') return 2;
        else if (ch == '+' || ch == '-') return 1;
        else return 0;
    }
}
