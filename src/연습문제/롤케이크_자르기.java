package 연습문제;

import java.util.HashMap;
import java.util.HashSet;

public class 롤케이크_자르기 {

    public int solution(int[] topping) {
        int answer = 0;
        int size = topping.length;

        // 첫 번째 롤케이크의 토핑을 first에 추가
        HashSet<Integer> first = new HashSet<>();
        first.add(topping[0]);

        // 두 번째부터 마지막까지의 토핑을 second에 추가
        // 같은 토핑이 나올 수 있으므로 HashMap을 사용하여 추가하며, 같은 토핑이 나온 수를 value로 저장
        HashMap<Integer, Integer> second = new HashMap<>();
        for (int i = 1; i < size; i++) {
            second.put(topping[i], second.getOrDefault(topping[i], 0) + 1);
        }

        // 첫 번째 토핑부터 하나씩 추가하면서 first와 second의 크기를 비교
        // first와 second의 크기가 같으면 answer를 1 증가
        for (int i = 1; i < size; i++) {
            first.add(topping[i]);
            second.put(topping[i], second.get(topping[i]) - 1);

            // 같은 토핑이 더 이상 없으면 HashMap에서 해당 토핑을 삭제
            if (second.get(topping[i]) == 0) {
                second.remove(topping[i]);
            }

            if (first.size() == second.size()) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        // return 2
        System.out.println(
            new 롤케이크_자르기().solution(new int[]{1, 2, 1, 3, 1, 4, 1, 2})
        );
    }
}
