package 연습문제;

import java.util.Arrays;

public class 최솟값_만들기 {

    public int solution(int[] A, int[] B) {
        int answer = 0;
        int n = A.length;

        // A와 B 배열을 오름차순으로 정렬합니다.
        Arrays.sort(A);
        Arrays.sort(B);

        // A와 B 배열에서 같은 위치의 수를 곱해 더합니다.
        for (int i = 0; i < n; i++) {
            answer += A[i] * B[n - i - 1];
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new 최솟값_만들기().solution(new int[]{1, 4, 2}, new int[]{5, 4, 4}));
    }
}
