package dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class N으로_표현 {

    public int solution(int N, int number) {
        // dp[i]: N을 i번 사용해서 만들 수 있는 수들의 집합
        List<Set<Integer>> dp = new ArrayList<>();

        // N을 1번 사용하는 경우부터 8번 사용하는 경우까지 계산
        for (int i = 0; i < 9; i++) {
            dp.add(new HashSet<>()); // HashSet으로 초기화
            int num = 0;
            for (int j = 0; j <= i; j++) {
                num += N * Math.pow(10, j); // N을 이어 붙여서 만든 수 계산
            }
            dp.get(i).add(num); // dp[i]에 num 추가
        }

        // N을 2번 이상 사용하는 경우부터 number를 찾을 때까지 계산
        for (int i = 1; i < 9; i++) {
            for (int j = 0; j < i; j++) {
                // dp[j]와 dp[i-j-1]에서 수를 하나씩 꺼내어 연산 수행
                for (int num1 : dp.get(j)) {
                    for (int num2 : dp.get(i - j - 1)) {
                        // 사칙연산 결과를 dp[i]에 추가
                        dp.get(i).add(num1 + num2);
                        dp.get(i).add(num1 - num2);
                        dp.get(i).add(num1 * num2);
                        if (num2 != 0) { // num2가 0이 아닌 경우 나눗셈 결과 추가
                            dp.get(i).add(num1 / num2);
                        }
                    }
                }
            }
            // number가 dp[i]에 있는 경우 최솟값 리턴
            if (dp.get(i).contains(number)) {
                return i + 1; // 인덱스는 0부터 시작하므로 +1
            }
        }

        return -1; // number를 만들 수 없는 경우 -1 리턴
    }

    public static void main(String[] args) {
        System.out.println(new N으로_표현().solution(5, 12));
    }
}
