package bfs;

import java.util.*;

public class 부대복귀 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new 부대복귀().solution(5, new int[][]{{1, 2}, {1, 4}, {2, 4}, {2, 5}, {4, 5}}, new int[]{1,3,5}, 5)));
    }

    private List<Integer>[] graph; // 인접 리스트로 그래프를 저장할 변수
    private long[] dis; // 출발 지점부터 해당 지점까지의 최단거리를 저장할 변수
    private static final long MAX = 1_000_000_000; // 경로가 존재하지 않을 경우, 초기값으로 사용할 변수

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        graph = new ArrayList[n + 1]; // n+1개의 ArrayList를 생성하여 각 노드에 대한 인접 리스트를 저장
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // roads 배열을 통해 그래프 정보 초기화
        for (int[] road : roads) {
            int s = road[0]; // 출발 지점
            int e = road[1]; // 도착 지점

            // 양방향 그래프이므로 양쪽 노드에 모두 추가
            graph[s].add(e);
            graph[e].add(s);
        }

        dis = new long[n + 1]; // n+1개의 배열 생성
        Arrays.fill(dis, MAX); // 최단 거리를 구하는 문제이므로 dis 배열을 최대값으로 초기화
        dijkstra(destination); // 목적지(destination)에서 시작하여 각 노드까지의 최단거리를 구하는 함수 실행

        int[] ans = new int[sources.length]; // 결과를 저장할 배열
        for (int i = 0; i < sources.length; i++) {
            ans[i] = (dis[sources[i]] < MAX) ? (int)dis[sources[i]] : -1; // 해당 노드까지의 최단거리가 존재하지 않으면 -1을 저장, 그렇지 않으면 최단거리를 저장
        }
        return ans; // 결과 리턴
    }

    private void dijkstra(int destination) {
        // 우선순위 큐를 이용하여 다익스트라 알고리즘을 구현한다.
        // 최소 거리를 먼저 처리하기 위해 우선순위 큐를 사용한다.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(destination); // 시작 지점 큐에 삽입
        dis[destination] = 0; // 시작 지점의 거리는 0으로 초기화

        while (!pq.isEmpty()) {
            int cn = pq.poll(); // 현재 위치에서 가장 가까운 노드 선택

            // 현재 위치에서 갈 수 있는 모든 노드에 대해
            for (int nn : graph[cn]) {
                // 더 짧은 거리를 발견한 경우에만 처리한다.
                if (dis[nn] > dis[cn] + 1) {
                    dis[nn] = dis[cn] + 1; // 거리 갱신
                    pq.offer(nn); // 다음으로 방문할 노드를 큐에 삽입
                }
            }
        }
    }
}