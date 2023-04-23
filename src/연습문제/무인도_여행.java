package 연습문제;

import java.util.*;

public class 무인도_여행 {

    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0};
    private static boolean[][] visited;
    private static int[][] map;
    private static int maxDay;

    public int[] solution(String[] maps) {
        int[] answer;

        int row = maps.length;
        int col = maps[0].length();
        map = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (maps[i].charAt(j) == 'X') {
                    map[i][j] = -1;
                } else {
                    map[i][j] = Character.getNumericValue(maps[i].charAt(j));
                }
            }
        }

        List<Integer> resultList = new ArrayList<>();
        visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] > 0 && !visited[i][j]) {
                    maxDay = 0;
                    dfs(i, j);
                    resultList.add(maxDay);
                }
            }
        }

        if (resultList.size() == 0) {
            answer = new int[1];
            answer[0] = -1;
        } else {
            answer = new int[resultList.size()];
            for (int i = 0; i < resultList.size(); i++) {
                answer[i] = resultList.get(i);
            }
            Arrays.sort(answer);
        }

        return answer;
    }

    private void dfs(int x, int y) {
        visited[x][y] = true;
        maxDay += map[x][y];

        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) {
                continue;
            }

            if (visited[nx][ny] || map[nx][ny] == -1) {
                continue;
            }

            dfs(nx, ny);
        }
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(new 무인도_여행().solution(new String[]{"X591X","X1X5X","X231X", "1XXX1"}))
        );
    }
}
