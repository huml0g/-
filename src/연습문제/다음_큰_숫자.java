package 연습문제;

public class 다음_큰_숫자 {

    public int solution(int n) {
        int count = Integer.bitCount(n);
        do {
            n++;
        } while (count != Integer.bitCount(n));
        return n;
    }

    public static void main(String[] args) {
    }
}
