package 연습문제;

import java.util.Arrays;

public class 테이블_해시_함수 {

    public int solution(int[][] data, int col, int rowBegin, int rowEnd) {
        // 1. data를 col번째 열을 기준으로 오름차순 정렬하고,
        // 만약 동일한 값이 있으면 첫 번째 열을 기준으로 내림차순 정렬한다.
        Arrays.sort(data, (o1, o2) -> {
            if (o1[col - 1] == o2[col - 1]) {
                return o2[0] - o1[0];
            }
            return o1[col - 1] - o2[col - 1];
        });

        // 2. 해시 값을 계산한다.
        int answer = 0;
        for (int i = rowBegin - 1; i < rowEnd; i++) {
            // 2.1 i번째 행의 S_i 값을 계산한다.
            int finalI = i;
            int s_i = Arrays.stream(data[i]).reduce(0, (sum, value) -> sum + (value % (finalI + 1)));

            // 2.2 S_i를 누적하여 bitwise XOR 한 값을 해시 값으로서 반환한다.
            answer ^= s_i;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(
            new 테이블_해시_함수().solution(new int[][]{{2,2,6},{1,5,10},{4,2,9},{3,8,3}}, 2, 2, 3)
        );
    }
}
