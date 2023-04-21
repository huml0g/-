package 연습문제;

public class 피로도 {

    int answer = 0; // 최종 결과값을 저장할 변수
    boolean[] visit; // 해당 던전 방문 여부를 저장할 배열

    public int solution(int k, int[][] dungeons) {
        visit = new boolean[dungeons.length]; // 방문 여부 배열 초기화

        dfs(0, k, dungeons); // DFS 탐색 실행

        return answer; // 결과값 반환
    }

    public void dfs(int depth, int k, int[][] dungeons) {
        for (int i = 0; i < dungeons.length; i++) { // 모든 던전에 대해 탐색
            if (!visit[i] && dungeons[i][0] <= k) { // 던전을 방문하지 않았고, 캐릭터의 체력으로 클리어 가능한 경우
                visit[i] = true; // 던전 방문 처리
                dfs(depth + 1, k - dungeons[i][1], dungeons); // DFS 탐색 실행 (깊이 + 1, 남은 체력 - 던전의 소비 체력, 던전 배열)
                visit[i] = false; // 던전 방문 처리 해제
            }
        }

        answer = Math.max(answer, depth); // 최대 깊이 갱신
    }

    /*public int solution(int k, int[][] dungeons) {
        boolean[] visit = new boolean[dungeons.length];
        Arrays.sort(dungeons, (a, b) -> b[0] - a[0]); // 내림차순 정렬

        int answer = 0;
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0, k});

        while (!stack.isEmpty()) {
            int[] cur = stack.pop();
            int curPos = cur[0];
            int curHp = cur[1];

            if (curPos == dungeons.length) { // 모든 던전을 방문한 경우
                answer = Math.max(answer, curPos);
                continue;
            }

            for (int i = 0; i < dungeons.length; i++) {
                if (!visit[i] && dungeons[i][0] <= curHp) { // 던전을 방문할 수 있는 경우
                    stack.push(new int[]{curPos + 1, curHp - dungeons[i][1]});
                    visit[i] = true;
                }
            }

            answer = Math.max(answer, curPos);
        }

        return answer;
    }*/

    public static void main(String[] args) {
        // return 3
        System.out.println(new 피로도().solution(80, new int[][]{{80,20},{50,40},{30,10}}));
    }
}