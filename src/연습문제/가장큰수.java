package 연습문제;

import java.util.*;

public class 가장큰수 {

    public String solution(int[] numbers) {
        String[] strNumbers = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strNumbers[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(strNumbers, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));

        if (strNumbers[0].equals("0")) {
            return "0";
        }

        StringBuilder answer = new StringBuilder();
        for (String str : strNumbers) {
            answer.append(str);
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        // [6102, 6210, 1062, 1026, 2610, 2106]
        System.out.println(
            new 가장큰수().solution(new int[]{3, 30, 34, 5, 9})
        );
    }
}
