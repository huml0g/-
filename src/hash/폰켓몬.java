package hash;

import java.util.Arrays;

public  class 폰켓몬 {

    // [3,3,3,2,2,4]
    // 3
    public int solution(int[] nums) {
        return Math.min(nums.length / 2, Arrays.stream(nums).distinct().toArray().length);
    }

    public static void main(String[] args) {
        System.out.println(new 폰켓몬().solution(new int[]{3,3,3,2,2,4}));
    }
}
