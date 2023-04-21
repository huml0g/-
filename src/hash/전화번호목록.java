package hash;

import java.util.Arrays;

public class 전화번호목록 {

    // ["119", "97674223", "1195524421"]
    // return false
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book); // 전화번호부 정렬

        for (int i = 0; i < phone_book.length - 1; i++) {
            // 현재 전화번호가 다음 전화번호의 접두어인지 비교
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }

        return true;
    }
}
