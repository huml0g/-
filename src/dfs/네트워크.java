package dfs;

class 네트워크 {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n]; // 방문 체크 배열
        int answer = 0; // dfs.네트워크 개수

        // 모든 컴퓨터를 시작점으로 탐색
        for (int i = 0; i < n; i++) {
            if (!visited[i]) { // 해당 컴퓨터를 방문하지 않았을 경우
                dfs(i, computers, visited); // DFS 탐색 수행
                answer++; // dfs.네트워크 개수 1 증가
            }
        }

        return answer; // 최종 dfs.네트워크 개수 반환
    }

    private void dfs(int start, int[][] computers, boolean[] visited) {
        visited[start] = true; // 방문 체크

        // 인접한 컴퓨터 중 방문하지 않은 컴퓨터를 방문
        for (int i = 0; i < computers.length; i++) {
            if (computers[start][i] == 1 && !visited[i]) { // 해당 컴퓨터와 연결된 컴퓨터를 확인하고 방문하지 않은 경우에만 DFS 탐색 수행
                dfs(i, computers, visited); // DFS 탐색 수행
            }
        }
    }
}