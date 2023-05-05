package graph;

import java.util.*;

public class 순위 {

/*
    public int solution(int n, int[][] results) {
        int[][] distArray = new int[n][n];

        // 승패 결과에 따라 인접 행렬(distArray)의 값을 업데이트합니다.
        for (int[] result : results) {
            int winner = result[0] - 1;
            int loser = result[1] - 1;
            distArray[winner][loser] = 1;
        }

        // 플로이드-와샬 알고리즘을 사용하여 모든 정점 간 최단 경로를 구합니다.
        for (int k = 0; k < n; k++) { // 경유지
            for (int i = 0; i < n; i++) { // 출발지
                for (int j = 0; j < n; j++) { // 도착지
                    if (distArray[i][j] == 0 && distArray[i][k] == 1 && distArray[k][j] == 1) {
                        // i+1이 k+1에 이기고, k+1이 j+1에 이기면 i+1이 j+1에 이김
                        distArray[i][j] = 1;
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            boolean hasValidResult = true;
            for (int j = 0; j < n; j++) {
                if (i == j) continue; // 같은 선수와의 비교는 제외
                if (distArray[i][j] == 0 && distArray[j][i] == 0) {
                    // i+1과 j+1이 한 번도 경기를 하지 않았으면 유효하지 않은 결과
                    hasValidResult = false;
                    break;
                }
            }
            if (hasValidResult) {
                answer++;
            }
        }

        return answer;
    }
*/

    public int solution(int n, int[][] results) {
        int answer = 0;
        // 인접 리스트 생성
        List<Integer>[] adjList = new ArrayList[n];
        // 인접 리스트 초기화
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        // 경기 결과를 인접 리스트에 추가
        for (int[] result : results) {
            adjList[result[0]-1].add(result[1]-1);
        }
        // 모든 선수에 대해 자신의 순위를 알 수 있는지 체크
        for (int i = 0; i < n; i++) {
            // 방문 여부를 저장하는 배열
            boolean[] visited = new boolean[n];
            // i번 선수를 시작점으로 하는 BFS 탐색을 수행하기 위해 선언
            int count = 0;
            // BFS 탐색을 위한 큐 생성과 초기화
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            visited[i] = true;
            // BFS 탐색 수행
            while (!queue.isEmpty()) {
                int curr = queue.poll();
                // 인접한 노드 중 방문하지 않은 노드를 큐에 추가
                for (int next : adjList[curr]) {
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                        count++;
                    }
                }
            }
            // i번 선수를 도달할 수 있는 이전 선수를 찾기 위해 큐 초기화
            queue.offer(i);
            visited[i] = true;
            // BFS 탐색을 통해 이전 선수를 찾음
            while (!queue.isEmpty()) {
                int curr = queue.poll();
                // 인접한 노드 중 이전 노드를 큐에 추가
                for (int prev = 0; prev < n; prev++) {
                    if (!visited[prev] && adjList[prev].contains(curr)) {
                        visited[prev] = true;
                        queue.offer(prev);
                        count++;
                    }
                }
            }
            // 자신을 제외한 모든 선수와의 승패를 알고 있으면 순위를 알 수 있음
            if (count == n-1) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(
            new 순위().solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}})
        );
    }
}
