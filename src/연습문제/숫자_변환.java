package 연습문제;

import java.util.LinkedList;
import java.util.Queue;

public class 숫자_변환 {

    public int solution(int x, int y, int n) {
        Queue<int[]> queue = new LinkedList<>(); // BFS를 위한 큐
        boolean[] visited = new boolean[1000001]; // 방문 여부를 저장하기 위한 배열

        queue.offer(new int[]{x, 0}); // 초기값 설정 (현재값, 현재까지의 연산 횟수)
        visited[x] = true; // 초기값 방문 표시

        while (!queue.isEmpty()) { // BFS 탐색 시작
            int[] current = queue.poll(); // 큐에서 현재값 가져오기
            int num = current[0]; // 현재값
            int cnt = current[1]; // 현재까지의 연산 횟수

            if (num == y) { // 목표값 도달한 경우
                return cnt; // 현재까지의 연산 횟수 반환
            }

            int[] next = {num + n, num * 2, num * 3}; // 다음 값 설정 (더하기, 곱하기 2, 곱하기 3)

            for (int i = 0; i < 3; i++) { // 다음 값을 큐에 넣기 위해 3번 반복
                if (next[i] <= 1000000 && !visited[next[i]]) { // 범위 내에 있고 방문하지 않은 경우
                    visited[next[i]] = true; // 방문 표시
                    queue.offer(new int[]{next[i], cnt + 1}); // 다음 값 큐에 삽입 (연산 횟수 1 증가)
                }
            }
        }

        return -1; // 큐가 비어있는 경우 변환할 수 없음
    }
}
