package 연습문제;

import java.util.Stack;

public class 짝지어_제거하기 {

    public int solution(String s) {
        // 스택 생성
        Stack<Character> stack = new Stack<>();
        // 문자열을 하나씩 순회하며 스택에 추가하거나 삭제한다.
        for (char c : s.toCharArray()) {
            // 스택이 비어있지 않고, 스택의 top과 현재 문자가 같으면 스택에서 top을 삭제한다.
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                // 스택이 비어있거나 스택의 top과 현재 문자가 다르면 스택에 현재 문자를 추가한다.
                stack.push(c);
            }
        }
        // 스택이 비어있으면 짝지어 제거하기가 가능하다는 뜻이므로 1을 반환하고,
        // 스택에 남아있는 문자가 있다면 짝지어 제거하기가 불가능하다는 뜻이므로 0을 반환한다.
        return stack.isEmpty() ? 1 : 0;
    }
}
