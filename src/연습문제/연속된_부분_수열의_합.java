package 연습문제;

import java.util.*;

public class 연속된_부분_수열의_합 {

    public int[] solution(int[] sequence, int k) {
        int n = sequence.length; // 수열의 길이를 저장
        Map<Integer, Integer> map = new HashMap<>(); // 각 합이 나오는 마지막 위치를 저장할 맵을 생성
        map.put(0, -1); // 초기값으로 합이 0인 위치는 -1로 설정
        int sum = 0; // 부분 수열의 합을 저장할 변수를 초기화
        int minLength = n + 1; // 최소 길이를 저장할 변수를 초기화
        int start = -1; // 부분 수열의 시작 인덱스를 저장할 변수를 초기화
        int end = -1; // 부분 수열의 끝 인덱스를 저장할 변수를 초기화

        for (int i = 0; i < n; i++) { // 모든 인덱스에 대해 반복
            sum += sequence[i]; // 현재 위치까지의 부분 수열의 합을 구하기

            if (map.containsKey(sum - k)) { // 현재 위치까지의 합에서 k를 뺀 값이 맵에 있으면
                int prevIndex = map.get(sum - k); // 그 위치를 가져오기
                int currLength = i - prevIndex; // 부분 수열의 길이를 구하기

                if (currLength < minLength) { // 현재 길이가 최소 길이보다 작으면
                    minLength = currLength; // 최소 길이를 갱신
                    start = prevIndex + 1; // 부분 수열의 시작 인덱스를 갱신
                    end = i; // 부분 수열의 끝 인덱스를 갱신
                }
            }

            if (!map.containsKey(sum)) { // 현재 합이 맵에 없으면
                map.put(sum, i); // 현재 위치를 맵에 추가
            }
        }

        return new int[]{start, end}; // 배열을 반환
    }

    public int[] solution2(int[] sequence, int k) {
        int left = 0, right = 0; // left와 right는 현재 부분 수열의 시작 인덱스와 끝 인덱스
        int sum = 0, minLength = Integer.MAX_VALUE; // sum은 현재 부분 수열의 합, minLength는 찾은 최소 길이
        int[] answer = new int[2]; // 답을 저장할 배열

        while (right < sequence.length) { // right가 배열의 끝에 도달할 때까지 반복
            sum += sequence[right]; // 현재 부분 수열에 right 인덱스의 원소를 추가
            right++; // right 인덱스를 한 칸 이동

            while (left < right && sum > k) { // sum이 k를 초과하면 부분 수열에서 left 인덱스의 원소를 제외
                sum -= sequence[left];
                left++;
            }

            if (sum == k) { // 현재 부분 수열의 합이 k와 같으면
                int length = right - left; // 현재 부분 수열의 길이를 계산
                if (length < minLength) { // 이전에 찾은 부분 수열보다 길이가 더 짧다면
                    minLength = length;
                    answer[0] = left; // 현재 부분 수열의 시작 인덱스와 끝 인덱스를 저장
                    answer[1] = right - 1;
                }
            }
        }

        return answer; // 답 반환
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(new 연속된_부분_수열의_합().solution(new int[]{1, 1, 1, 2, 3, 4, 5}, 5))
        );
    }
}
