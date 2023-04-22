package 연습문제;

import java.util.HashSet;
import java.util.Set;

public class 연속_부분_수열_합의_개수 {

    // 원형 수열
    public int solution(int[] nums) {
        int n = nums.length; // 배열의 길이
        Set<Integer> sumSet = new HashSet<>(); // 합을 저장할 Set

        // 부분 수열의 길이
        for(int len=1; len<=n; len++) {
            // 시작 위치
            for(int start=0; start<n; start++) {
                int sum = 0; // 현재 부분 수열의 합
                // 부분 수열 내의 인덱스
                for(int j=0; j<len; j++) {
                    int idx = (start+j) % n; // 인덱스 계산
                    sum += nums[idx]; // 현재 부분 수열의 합 계산
                }
                // 구한 합을 set에 추가
                sumSet.add(sum);
            }
        }

        return sumSet.size(); // 결과 반환
    }

    public static void main(String[] args) {
        // 18
        System.out.println(
            new 연속_부분_수열_합의_개수().solution(new int[]{7,9,1,1,4})
        );
    }
}
