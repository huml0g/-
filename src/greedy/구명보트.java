package greedy;

import java.util.Arrays;

public class 구명보트 {

    // two pointer
    public int solution(int[] people, int limit) {
        int answer = 0;
        int left = 0;
        int right = people.length - 1;
        Arrays.sort(people);

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        // result = 3
        System.out.println(
                new 구명보트().solution(new int[]{70,50,80,50}, 100)
        );
    }
}
