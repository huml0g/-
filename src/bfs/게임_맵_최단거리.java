package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class 게임_맵_최단거리 {

    public int solution(int[][] maps) {
        // 2차원 배열의 행(row)과 열(col)의 길이를 구합니다.
        int rows = maps.length;
        int cols = maps[0].length;
        // 이동할 수 있는 방향을 나타내는 dx, dy 배열을 초기화합니다.
        int[] dx = {-1, 1};
        int[] dy = {0, 0, -1, 1};
        // BFS 탐색을 위한 큐와 방문 여부를 저장할 2차원 배열을 초기화합니다.
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];
        // 시작 위치 (0, 0)을 큐에 넣고 방문 여부를 true로 변경합니다.
        queue.offer(new int[]{0, 0, 1});
        visited[0][0] = true;

        // BFS 탐색을 수행합니다.
        while (!queue.isEmpty()) {
            // 큐에서 현재 위치를 꺼내서 x, y, distance 변수에 저장합니다.
            int[] currentPosition = queue.poll();
            int x = currentPosition[0];
            int y = currentPosition[1];
            int distance = currentPosition[2];

            // 만약 현재 위치가 (rows-1, cols-1) 즉, 목적지에 도착했다면 거리(distance)를 반환합니다.
            if (x == rows - 1 && y == cols - 1) {
                return distance;
            }

            // 현재 위치에서 이동할 수 있는 모든 방향을 탐색합니다.
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 이동하려는 위치가 범위를 벗어나거나 갈 수 없는 위치인 경우는 건너뜁니다.
                if (nx < 0 || ny < 0 || nx >= rows || ny >= cols) {
                    continue;
                }

                // 이동하려는 위치가 벽(0)인 경우나 이미 방문한 위치인 경우는 건너뜁니다.
                if (maps[nx][ny] == 0 || visited[nx][ny]) {
                    continue;
                }

                // 이동하려는 위치를 큐에 넣고 방문 여부를 true로 변경합니다.
                queue.offer(new int[]{nx, ny, distance + 1});
                visited[nx][ny] = true;
            }
        }

        // 도착지에 도달할 수 없는 경우 -1을 반환합니다.
        return -1;
    }
}
