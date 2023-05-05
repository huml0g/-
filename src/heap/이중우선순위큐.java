package heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class 이중우선순위큐 {

    public int[] solution(String[] operations) {
        Queue<Integer> minQueue = new PriorityQueue<>();
        Queue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (String operation : operations) {
            String command = operation.substring(0, 1);
            String number = operation.substring(2);
            if ("I".equals(command)) {
                int n = Integer.parseInt(number);
                minQueue.offer(n);
                maxQueue.offer(n);
            } else {
                if ("-1".equals(number)) {
                    // 최솟값 삭제
                    if (!minQueue.isEmpty()) {
                        int min = minQueue.poll();
                        maxQueue.remove(min);
                    }
                } else {
                    if (!maxQueue.isEmpty()) {
                        int max = maxQueue.poll();
                        minQueue.remove(max);
                    }
                }
            }
        }


        int[] answer = new int[]{0, 0};

        if (!maxQueue.isEmpty()) {
            answer[0] = maxQueue.poll();
        }
        if (!minQueue.isEmpty()) {
            answer[1] = minQueue.poll();
        }

        return answer;
    }

    // I 숫자 큐에 주어진 숫자를 삽입합니다.
    // D 1	큐에서 최댓값을 삭제합니다.
    // D -1	큐에서 최솟값을 삭제합니다.
    public static void main(String[] args) {
        // 16과 -5643을 삽입합니다.
        // 최솟값을 삭제합니다. -5643이 삭제되고 16이 남아있습니다.
        // 최댓값을 삭제합니다. 16이 삭제되고 이중 우선순위 큐는 비어있습니다.
        // 우선순위 큐가 비어있으므로 최댓값 삭제 연산이 무시됩니다.
        // 123을 삽입합니다.
        // 최솟값을 삭제합니다. 123이 삭제되고 이중 우선순위 큐는 비어있습니다.
        System.out.println(
                Arrays.toString(
                    new 이중우선순위큐().solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"})
                )
        );
        // -45와 653을 삽입후 최댓값(653)을 삭제합니다. -45가 남아있습니다.
        // -642, 45, 97을 삽입 후 최댓값(97), 최솟값(-642)을 삭제합니다. -45와 45가 남아있습니다.
        // 333을 삽입합니다.
        System.out.println(
                Arrays.toString(
                        new 이중우선순위큐().solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"})
                )
        );
    }
}
