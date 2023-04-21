package dp;

public class 사칙연산 {

    public static int solution(String[] arr) {
        int n = arr.length / 2 + 1; // 연산자의 개수는 숫자보다 항상 1개 적으므로 배열의 길이를 2로 나눈 뒤 1을 더해줍니다.
        int[][] max = new int[n][n]; // 최댓값을 저장할 DP 테이블입니다.
        int[][] min = new int[n][n]; // 최솟값을 저장할 DP 테이블입니다.

        // 각 숫자를 최댓값과 최솟값으로 초기화합니다.
        for (int i = 0; i < n; i++) {
            max[i][i] = Integer.parseInt(arr[i * 2]);
            min[i][i] = Integer.parseInt(arr[i * 2]);
        }

        // 길이가 2 이상인 구간에 대해서 연산을 수행합니다.
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1; // 구간의 끝 인덱스입니다.

                // 초기값은 구간 내 첫번째 숫자로 설정합니다.
                max[i][j] = Integer.MIN_VALUE;
                min[i][j] = Integer.MAX_VALUE;

                // k는 구간 내 연산자의 인덱스입니다.
                for (int k = i; k < j; k++) {
                    // 구간 내 k번째 연산자의 연산 결과를 계산합니다.
                    int res1 = calculate(max[i][k], max[k+1][j], arr[k*2+1]);
                    int res2 = calculate(max[i][k], min[k+1][j], arr[k*2+1]);
                    int res3 = calculate(min[i][k], max[k+1][j], arr[k*2+1]);
                    int res4 = calculate(min[i][k], min[k+1][j], arr[k*2+1]);

                    // 최댓값과 최솟값을 갱신합니다.
                    max[i][j] = Math.max(max[i][j], Math.max(res1, Math.max(res2, Math.max(res3, res4))));
                    min[i][j] = Math.min(min[i][j], Math.min(res1, Math.min(res2, Math.min(res3, res4))));
                }
            }
        }

        return max[0][n-1]; // 전체 구간의 최댓값을 반환합니다.
    }

    // 두 숫자와 연산자를 입력으로 받아서 연산 결과를 반환하는 함수입니다.
    private static int calculate(int a, int b, String op) {
        if (op.equals("+")) {
            return a + b;
        } else {
            return a - b;
        }
    }
}
