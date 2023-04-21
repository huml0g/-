package 연습문제;

import java.util.Arrays;
import java.util.Stack;

public class 뒤에_있는_큰_수_찾기 {

    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>(); // 빈 스택 생성

        // 배열의 각 원소에 대해 반복
        for (int i = 0; i < numbers.length; i++) {
            // 스택이 비어있지 않고 현재 원소가 스택의 top보다 큰 경우
            while (!stack.isEmpty() && numbers[i] > numbers[stack.peek()]) {
                answer[stack.pop()] = numbers[i]; // 현재 원소가 더 크므로 이전 원소는 뒷 큰수가 됨
            }
            stack.push(i); // 현재 원소 인덱스를 스택에 삽입
        }

        // 스택에 남아있는 인덱스들은 뒷 큰수가 없는 원소이므로 -1로 초기화
        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }

        return answer; // 뒷 큰수들을 담은 배열 리턴
    }

    public static void main(String[] args) {
        // [-1, 5, 6, 6, -1, -1]
        System.out.println(
                Arrays.toString(new 뒤에_있는_큰_수_찾기().solution(new int[]{9, 1, 5, 3, 6, 2}))
        );
    }
}
