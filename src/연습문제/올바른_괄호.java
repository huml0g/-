package 연습문제;

import java.util.Stack;

public class 올바른_괄호 {



    public boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }


    public static void main(String[] args) {
        System.out.println(new 올바른_괄호().solution("()()"));
    }
}
