package 연습문제;

import java.util.*;

public class 섬_연결하기 {

    private static final int NOTVISITED = -1;

    public int solution(int N, int[][] costs) {
        // save connection to graph
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < N; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] cost : costs) {
            int n = cost[0];
            int m = cost[1];
            int w = cost[2];
            graph.get(n).add(new int[]{w, m});
            graph.get(m).add(new int[]{w, n});
        }

        // search
        int[] passed = new int[N]; // 시작 노드에서 다른 노드로 이동할 때 드는 비용을 저장하는 배열
        Arrays.fill(passed, NOTVISITED); // 모든 노드를 방문하지 않은 것으로 초기화
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        heap.offer(new int[]{0, 0}); // 시작 노드를 우선순위 큐에 삽입

        while (!heap.isEmpty()) {
            int[] pair = heap.poll();
            int w = pair[0]; // 현재 노드까지 이동하는 데 드는 비용
            int n = pair[1]; // 현재 노드 번호
            if (passed[n] != NOTVISITED) continue; // 이미 방문한 노드면 건너뜀
            passed[n] = w; // 현재 노드 방문
            for (int[] next : graph.get(n)) { // 현재 노드와 연결된 모든 노드에 대해
                int nw = next[0]; // 다음 노드까지의 비용
                int cnode = next[1]; // 다음 노드 번호
                heap.offer(new int[]{nw, cnode}); // 우선순위 큐에 삽입
            }
        }

        return Arrays.stream(passed).sum() - passed[0]; // 모든 노드를 방문하는 데 드는 비용 반환
    }

    public static void main(String[] args) {
        System.out.println(
            new 섬_연결하기().solution(4, new int[][]{{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}})
        );
    }
}
