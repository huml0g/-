package 연습문제;

import java.util.Arrays;

public class 이진_변환_반복하기 {

    /*public int[] solution(String s) {
        int[] answer = {0, 0};

        while (!"1".equals(s)) {
            String one = "";
            for (int i = 0; i < s.length(); i++) {
                String number = s.substring(i, i + 1);
                if ("1".equals(number)) {
                    one += number;
                } else {
                    answer[1]++;
                }
            }
            answer[0]++;
            s = Integer.toBinaryString(one.length());
        }
        return answer;
    }*/

    /*public int[] solution(String s) {
        int count = 0, zeroCount = 0;

        while (!"1".equals(s)) {
            int length = s.replaceAll("0", "").length();
            count++;
            zeroCount += s.length() - length;
            s = Integer.toBinaryString(length);
        }
        return new int[]{count, zeroCount};
    }*/

    public int[] solution(String s) {
        int count = 0, zeroCount = 0;

        while (!"1".equals(s)) {
            int length = s.replaceAll("0", "").length();
            count++;
            zeroCount += s.length() - length;
            s = Integer.toBinaryString(length);
        }
        return new int[]{count, zeroCount};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new 이진_변환_반복하기().solution("110010101001")));
    }
}
