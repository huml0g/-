package 연습문제;

import java.util.Stack;

public class 괄호회전하기 {

    public int solution(String s) {
        int answer = 0;
        int len = s.length();

        // s를 왼쪽으로 x(0 <= x < len)칸 회전시켰을 때 올바른 괄호 문자열인지 확인합니다.
        for (int i = 0; i < len; i++) {
            // 문자열 s를 왼쪽으로 i칸 회전시킵니다.
            String rotated = s.substring(i) + s.substring(0, i);
            // 회전된 문자열에서 괄호를 확인하기 위해 스택을 이용합니다.
            Stack<Character> stack = new Stack<>();

            // 회전된 문자열을 순회하며 괄호를 확인합니다.
            boolean isCorrect = true;
            for (int j = 0; j < len; j++) {
                char ch = rotated.charAt(j);
                if (ch == '(' || ch == '{' || ch == '[') {
                    // 열린 괄호는 스택에 추가합니다.
                    stack.push(ch);
                } else {
                    // 닫힌 괄호가 나온 경우, 스택에서 짝이 맞는 열린 괄호를 꺼냅니다.
                    if (stack.isEmpty()) {
                        isCorrect = false;
                        break;
                    }
                    char top = stack.pop();
                    if ((ch == ')' && top != '(') || (ch == '}' && top != '{') || (ch == ']' && top != '[')) {
                        isCorrect = false;
                        break;
                    }
                }
            }

            if (isCorrect && stack.isEmpty()) {
                // 괄호를 모두 확인한 후 스택이 비어있는 경우, 올바른 괄호 문자열입니다.
                // 회전된 횟수를 answer에 추가합니다.
                answer++;
            }
        }

        // 모든 회전에 대해 확인한 후, 올바른 괄호 문자열이 되는 경우의 수를 반환합니다.
        return answer;
    }

    // 0	"[](){}"	O
    // 1	"](){}["	X
    // 2	"(){}[]"	O
    // 3	"){}[]("	X
    // 4	"{}[]()"	O
    // 5	"}[](){"	X
    public static void main(String[] args) {
        new 괄호회전하기().solution("[](){}");
    }
}
