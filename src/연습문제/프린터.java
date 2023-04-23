package 연습문제;

import java.util.*;

public class 프린터 {

    public int solution(int[] priorities, int location) {
        int answer = 0; // 출력된 문서의 수
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 우선순위 큐 생성 (내림차순)

        // 2. priorities값을 우선순위 큐에 담는다.
        for(int n : priorities){
            pq.offer(n); // 우선순위 큐에 추가
        }

        while(!pq.isEmpty()){
            for(int i = 0; i < priorities.length; i++){
                if(pq.peek() == priorities[i]){ // 3. 가장 높은 우선순위를 가진 문서를 찾는다.
                    pq.poll(); // 4. 우선순위 큐에서 해당 문서를 제거한다.
                    answer++; // 5. 출력된 문서 수 증가

                    if(location == i) { // 6. 찾으려는 문서와 현재 문서의 위치를 비교한다.
                        return answer; // 찾으려는 문서의 위치와 현재 문서의 위치가 같다면, 출력된 문서 수를 반환하고 종료한다.
                    }
                }
            }
        }

        return answer; // 모든 문서를 확인한 경우, 출력된 문서 수를 반환하고 종료한다.
    }

    public static void main(String[] args) {
        System.out.println(
                new 프린터().solution(new int[]{2, 4, 8, 2, 9, 3, 3}, 2)
        );
    }
}