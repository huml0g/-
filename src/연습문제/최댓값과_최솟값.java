package 연습문제;

public class 최댓값과_최솟값 {

    public String solution(String s) {
        String[] array = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (String number : array) {
            min = Math.min(min, Integer.parseInt(number));
            max = Math.max(max, Integer.parseInt(number));
        }
        return min + " " + max;
    }

    public static void main(String[] args) {
        System.out.println(new 최댓값과_최솟값().solution("1 2 3 4"));
    }
}
