package 연습문제;

public class 마법의_엘리베이터 {

    public int solution(int storey) {
        int answer = 0;

        // storey가 0보다 크면 계속해서 반복문을 수행
        while (storey > 0) {
            // storey의 일의 자리 수와 십의 자리 수 구하기
            int cur = storey % 10;
            int next = (storey / 10) % 10;

            // 현재 층의 일의 자리 수가 5보다 큰 경우
            if (cur > 5) {
                // 다음 층으로 올라가는 데 필요한 비용을 계산하고, answer에 추가
                answer += 10 - cur;
                // storey에 10을 더해 다음 층으로 올라가기
                storey += 10;
            }
            // 현재 층의 일의 자리 수가 5인 경우
            else if (cur == 5) {
                // 다음 층의 십의 자리 수가 5보다 크거나 같으면
                if (next >= 5) {
                    // 다음 층으로 올라가는 데 필요한 비용을 계산하고, answer에 추가
                    answer += 10;
                    // storey에 10을 더해 다음 층으로 올라가기
                    storey += 10;
                }
                // 다음 층의 십의 자리 수가 5보다 작으면
                else {
                    // 현재 층으로 남아있는 경우이므로, answer에 5를 추가
                    answer += 5;
                }
            }
            // 현재 층의 일의 자리 수가 5보다 작은 경우
            else {
                // 다음 층으로 올라가는 데 필요한 비용을 계산하고, answer에 추가
                answer += cur;
            }

            // storey에서 일의 자리 수를 제거하여 다음 반복문에서 사용할 수 있도록
            storey /= 10;
        }

        return answer;
    }

    public static void main(String[] args) {
        // return 6
        System.out.println(
            new 마법의_엘리베이터().solution(16)
        );
    }
}
