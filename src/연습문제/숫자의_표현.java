package 연습문제;

public class 숫자의_표현 {

    // k는 연속된 자연수의 개수를 나타냅니다. 예를 들어, k=3이면 1+2+3 또는 2+3+4와 같은 3개의 연속된 자연수의 합을 의미합니다.
    // 분자 numerator는 k개의 연속된 자연수의 합을 n으로 만들기 위해 필요한 수의 합으로 계산됩니다. n * 2에서 k * (k-1)을 뺀 값이 numerator에 저장됩니다. 이때, k * (k-1)은 1에서 k까지의 합과 같습니다.
    // 분모 denominator는 k개의 연속된 자연수의 합을 나타내는 식으로 계산됩니다. k에 2를 곱한 값이 denominator에 저장됩니다.
    // 분자가 양수이고 분자를 분모로 나누어 떨어지면, 해당하는 k값으로 연속된 자연수의 합을 구할 수 있으므로, 경우의 수를 1 증가시킵니다.
    // 마지막으로, 자연수 n을 연속된 자연수의 합으로 나타낼 수 있는 경우의 수를 반환합니다.
    public int solution(int n) {
        int count = 0; // 자연수 n을 연속한 자연수로 나타낼 수 있는 경우의 수
        for (int k = 1; k <= n; k++) { // k는 연속된 자연수의 개수를 나타냄
            int numerator = n * 2 - k * (k - 1); // 연속된 자연수의 합인 분자 계산
            int denominator = k * 2; // 분모 계산
            if (numerator > 0 && numerator % denominator == 0) { // 분자가 양수이고 분자를 분모로 나누어 떨어지면
                count++; // 경우의 수 1 증가
            }
        }
        return count; // 자연수 n을 연속한 자연수로 나타낼 수 있는 경우의 수 반환
    }
}
