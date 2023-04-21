package dfs;

import java.util.*;

public class 여행경로 {

    public String[] solution(String[][] tickets) {
        Map<String, List<String>> graph = new HashMap<>();
        List<String> route = new ArrayList<>();

        // 그래프 생성
        for (String[] ticket : tickets) {
            if (!graph.containsKey(ticket[0])) {
                graph.put(ticket[0], new ArrayList<>());
            }
            graph.get(ticket[0]).add(ticket[1]);
        }

        // 알파벳 역순으로 정렬
        for (List<String> destinations : graph.values()) {
            destinations.sort(Collections.reverseOrder());
        }

        dfs("ICN", graph, route);

        String[] answer = new String[route.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = route.get(i);
        }
        return answer;
    }

    private void dfs(String start, Map<String, List<String>> graph, List<String> route) {
        // 현재 위치에서 갈 수 있는 모든 경로 탐색
        while (graph.containsKey(start) && !graph.get(start).isEmpty()) {
            String destination = graph.get(start).remove(graph.get(start).size() - 1);
            dfs(destination, graph, route);
        }
        // 경로 추가
        route.add(0, start);
    }


    public static void main(String[] args) {
        String[][] data = new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        System.out.println(Arrays.toString(new 여행경로().solution(data)));
    }
}
