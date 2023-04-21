package 연습문제;

import java.util.ArrayList;
import java.util.List;

public class JadenCase_문자열_만들기 {

    public String solution(String s) {
        String answer = s.substring(0, 1).toUpperCase();

        for (int i = 1, n = s.length(); i < n; i++) {
            String prev = s.substring(i - 1, i);
            String str = s.substring(i, i + 1);
            if (" ".equals(prev)) {
                answer += str.toUpperCase();
            } else {
                answer += str.toLowerCase();
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new JadenCase_문자열_만들기().solution("3people unFollowed me"));
    }
}
