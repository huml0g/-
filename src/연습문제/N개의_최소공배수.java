package 연습문제;

import java.util.HashMap;
import java.util.Map;

public class N개의_최소공배수 {

    public int solution(int[] arr) {
        // 최소공배수를 계산하기 위해 입력된 수들을 소인수분해하여 소수 인수와 인수의 지수를 저장할 Map을 생성합니다.
        Map<Integer, Integer> factorMap = new HashMap<>();

        // 입력된 수들을 순회합니다.
        for (int num : arr) {
            // 각 수를 소인수분해하여 소수 인수와 인수의 지수를 저장한 Map을 구합니다.
            Map<Integer, Integer> numFactors = primeFactors(num);

            // 소인수분해한 결과를 factorMap에 반영합니다.
            for (int factor : numFactors.keySet()) {
                // 이미 factorMap에 저장된 지수 중 더 큰 값을 사용하기 위해 Math.max를 사용하여 최대 값을 구합니다.
                int maxPower = Math.max(numFactors.get(factor), factorMap.getOrDefault(factor, 0));
                // factorMap에 소수 인수와 지수를 저장합니다.
                factorMap.put(factor, maxPower);
            }
        }

        // 최소공배수를 구하기 위해 소수 인수와 지수를 곱하여 결과를 구합니다.
        int lcm = 1;
        for (int factor : factorMap.keySet()) {
            lcm *= Math.pow(factor, factorMap.get(factor));
        }
        return lcm;
    }

    // 소인수 분해 알고리즘, 유클리드 호제법을 사용한 방식도 있다.
    // 주어진 수를 소인수분해하여 소수 인수와 인수의 지수를 저장한 Map을 반환하는 함수입니다.
    private Map<Integer, Integer> primeFactors(int num) {
        // 소인수분해 결과를 저장할 Map을 생성합니다.
        Map<Integer, Integer> factors = new HashMap<>();

        // 입력된 수를 소인수분해합니다.
        int factor = 2;
        while (num > 1) {
            if (num % factor == 0) {
                // factor가 num의 인수인 경우, factor를 소인수로 추가하고 factor의 지수를 1 증가시킵니다.
                factors.put(factor, factors.getOrDefault(factor, 0) + 1);
                num /= factor;
            } else {
                // factor가 num의 인수가 아닌 경우, factor를 1 증가시켜 다음 수를 확인합니다.
                factor++;
            }
        }
        return factors;
    }

}
