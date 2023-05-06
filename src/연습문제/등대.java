package 연습문제;

import java.util.*;

public class 등대 {

    public int solution(int n, int[][] lighthouse) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < lighthouse.length; i++) {
            int a = lighthouse[i][0];
            int b = lighthouse[i][1];
            List<Integer> nodeA = graph.computeIfAbsent(a, k -> new ArrayList<>());
            List<Integer> nodeB = graph.computeIfAbsent(b, k -> new ArrayList<>());
            nodeA.add(b);
            nodeB.add(a);
        }

        int answer = 0;
        int[] visited = new int[n + 1];
        dfs(1, graph, visited);

        for (int i : visited) {
            if (i >= 2) {
                answer++;
            }
        }
        return answer;
    }

    public void dfs(int start, Map<Integer, List<Integer>> graph, int[] visited) {
        visited[start] = 1;

        for (Integer next : graph.get(start)) {
            if (visited[next] == 0) {
                dfs(next, graph, visited);
                if (visited[next] == 1) {
                    visited[start]++;
                }
            }
        }
    }

    public static void main(String[] args) {

        System.out.println(
            new 등대().solution(8, new int[][]{{1, 2}, {1, 3}, {1, 4}, {1, 5}, {5, 6}, {5, 7}, {5, 8}})
        );
        System.out.println(
            new 등대().solution(10, new int[][]{{4, 1}, {5, 1}, {5, 6}, {7, 6}, {1, 2}, {1, 3}, {6, 8}, {2, 9}, {9, 10}})
        );
    }
}
