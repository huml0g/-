package 연습문제;

import java.util.Collections;
import java.util.PriorityQueue;

public class 야근_지수 {

    public long solution(int n, int[] works) {
        long answer = 0;

        // works의 합이 n 이하면 0을 반환합니다.
        if (sum(works) <= n) {
            return 0;
        }

        // 우선순위 큐를 이용하여 works의 각 요소를 역순으로 정렬합니다.
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int work : works) {
            pq.offer(work);
        }

        // 큐에서 가장 큰 값을 꺼내서 1을 뺀 값을 다시 큐에 넣습니다.
        // 이를 n번 반복합니다.
        while (n > 0) {
            int currWork = pq.poll();
            pq.offer(currWork - 1);
            n--;
        }

        // 모든 작업량을 제곱하여 더한 값을 반환합니다.
        while (!pq.isEmpty()) {
            answer += Math.pow(pq.poll(), 2);
        }

        return answer;
    }

    // 배열의 합을 계산하는 메서드입니다.
    private int sum(int[] works) {
        int sum = 0;
        for (int work : works) {
            sum += work;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(
            new 야근_지수().solution(4, new int[]{4, 3, 3})
        );
    }
}
