package 연습문제;

import java.util.Arrays;

public class 카펫 {

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow; // 전체 격자 수 구하기
        int height = 3; // 세로 길이는 3부터 시작

        // 세로 길이를 3부터 하나씩 증가시키면서 카펫의 가로, 세로 크기 구하기
        while (true) {
            if (sum % height == 0) { // 전체 격자 수가 세로 길이로 나누어 떨어지는 경우
                int width = sum / height; // 가로 길이 구하기
                int yellowWidth = width - 2; // 노란색 격자의 가로 길이 구하기
                int yellowHeight = height - 2; // 노란색 격자의 세로 길이 구하기
                int yellowCount = yellowWidth * yellowHeight; // 노란색 격자의 개수 구하기

                if (yellowCount == yellow) { // 노란색 격자의 개수가 주어진 yellow와 일치하는 경우
                    answer[0] = width; // 가로 길이를 answer 배열의 첫 번째 요소로 설정
                    answer[1] = height; // 세로 길이를 answer 배열의 두 번째 요소로 설정
                    break; // 반복문을 종료
                }
            }
            height++; // 세로 길이를 하나씩 증가
        }

        return answer; // 정답 배열을 반환
    }

    public static void main(String[] args) {
        // return [4, 3]
        System.out.println(Arrays.toString(new 카펫().solution(10, 2)));
    }
}
