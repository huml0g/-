package 연습문제;

public class 선입_선출_스케줄링 {

/*    public int solution(int n, int[] cores) {
        int answer = 0;
        int[] worker = cores.clone();
        n -= worker.length;

        while (n > 0) {
            for (int i = 0; i < worker.length; i++) {
                if (--worker[i] == 0) {
                    worker[i] = cores[i];
                    --n;
                }
                if (n == 0) {
                    answer = i + 1;
                    break;
                }
            }
        }
        return answer;
    }*/

    public int solution(int n, int[] cores) {
        int answer = 0;

        if (n <= cores.length) {
            return n; // 코어수 보다 작으면 바로 해당 코어를 반환
        }

        int minTime = Integer.MAX_VALUE;
        for (int i : cores) { // 가장 작은 처리 시간 구하기
            if (minTime > i) {
                minTime = i;
            }
        }

        // 이분 탐색을 위해 최소 시간과 최대 시간 설정
        int start = n / cores.length * minTime;
        int end = n * minTime;

        while (start <= end) {
            int mid = (start + end) / 2;
            int cnt = cores.length; // 0초에 해당 코어들에 작업이 하나씩 들어감
            int currentCnt = 0; // 현재 시간에 할당받은 작업 양

            for (int core : cores) {
                cnt += mid / core; // 현재 시간까지 한 양
                if (mid % core == 0) { // 만일 현재 시간에 막 작업을 받은 것이라면
                    cnt--;
                    currentCnt++;
                }
            }

            if (cnt >= n) { // 현재 시점에 작업받은 것을 추가하지도 않았음에도 n을 넘기면 최대 시간 줄임
                end = mid - 1;
            } else if ((cnt + currentCnt) < n) { // 추가했음에도 n보다 부족하면 최소 시간 늘림
                start = mid + 1;
            } else { // (현재시점 전에 한 양 + 현재시점에 한 양)이 n을 넘기면
                for (int i = 0; i < cores.length; i++) {
                    if (mid % cores[i] == 0) {
                        cnt++;
                    }
                    if (cnt == n) { // n개째를 받는 순간의 인덱스를 반환
                        return i + 1;
                    }
                }
            }
        }

        return answer;
    }

    // 처음 3개의 작업은 각각 1,2,3번에 들어가고,
    // 1시간 뒤 1번 코어에 4번째 작업,다시 1시간 뒤
    // 1,2번 코어에 5,6번째 작업이 들어가므로 2를 반환해주면 됩니다.
    public static void main(String[] args) {
        System.out.println(
            new 선입_선출_스케줄링().solution(6, new int[]{1,2,3})
        );
    }
}
