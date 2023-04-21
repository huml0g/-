package greedy;

import java.util.LinkedList;

public class 거스름돈 {

    public int[] solution(int money, int[] coins) {
        int[] answer = new int[coins.length];
        int idx = 0;
        while(money > 0) {
            if(money >= coins[idx]) {
                answer[idx]++;
                money -= coins[idx];
            } else {
                idx++;
            }
        }
        return answer;
    }
}
