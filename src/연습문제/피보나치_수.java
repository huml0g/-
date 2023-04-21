package 연습문제;

import java.util.Arrays;

public class 피보나치_수 {

    // 0, 1, 1, 2, 3, 5
    public int solution(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new 피보나치_수().solution(5));
    }
}
