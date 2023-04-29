package 연습문제;

public class 카운트_다운 {

    int[][] dp;
    int INF = 100001;

    public int[] solution(int target) {
        dp = new int[target + 1][2]; // 0: 다트 수, 1: 싱글/불 횟수
        for (int i = 1; i <= target; i++) {
            dp[i][0] = INF; // 초기값 설정
        }

        return throwDart(target); // 다트 던지기 시작
    }

    // 다트 던지기
    int[] throwDart(int n) {
        if (dp[n][0] == INF) { // 만약 이전에 방문한 적 없다면
            if (n >= 50) { // 불 맞추기
                int[] temp = throwDart(n - 50); // 불 맞추고 나서의 최소값 구하기
                // 현재 상태의 값이 최소값보다 크다면 갱신
                if (temp[0] != INF && temp[0] + 1 < dp[n][0] || temp[0] + 1 == dp[n][0] && temp[1] + 1 > dp[n][1]) {
                    dp[n][0] = 1 + temp[0];
                    dp[n][1] = 1 + temp[1];
                }
            }

            int start = Math.min(n, 20); // 싱글/더블/트리플 셋 중 시작 값
            for (int i = start; i >= 1; i--) {
                for (int j = 1; j <= 3; j++) { // 싱글, 더블, 트리플
                    if (n >= i * j) { // 만약 n보다 적은 값으로 싱글/더블/트리플 중 하나를 던질 수 있다면
                        int[] temp = throwDart(n - i * j); // 최소값 구하기
                        int cnt = (j == 1) ? 1 : 0; // 싱글일 경우 카운트하기
                        // 현재 상태의 값이 최소값보다 크다면 갱신
                        if (temp[0] != INF && (temp[0] + 1 < dp[n][0] || temp[0] + 1 == dp[n][0] && temp[1] + cnt > dp[n][1])) {
                            dp[n][0] = 1 + temp[0];
                            dp[n][1] = cnt + temp[1];
                        }
                    }
                }
            }
        }

        return dp[n]; // 최소값 반환
    }
}
