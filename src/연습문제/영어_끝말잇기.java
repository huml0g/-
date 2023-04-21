package 연습문제;

import java.util.*;

public class 영어_끝말잇기 {


/*    public int[] solution(int n, String[] words) {
        int number = 0, order = 0;
        Map<String, Boolean> wordMap = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            String currentWord = words[i];
            Boolean word = wordMap.get(currentWord);
            if (word != null ||
                    (i > 0 && !words[i - 1].substring(words[i - 1].length() - 1).equals(currentWord.substring(0, 1)))) {
                number = i % n + 1;
                order = (int) Math.ceil(i / n) + 1;
                break;
            } else {
                wordMap.put(currentWord, true);
            }
        }

        return new int[]{number, order};
    }*/

    public int[] solution(int n, String[] words) {
        Set<String> wordSet = new HashSet<>();
        int order = 0, number = 0;

        for (int i = 0; i < words.length; i++) {
            String currentWord = words[i];
            if (i > 0 && !words[i - 1].endsWith(currentWord.substring(0, 1)) || !wordSet.add(currentWord)) {
                order = (i / n) + 1;
                number = (i % n) + 1;
                break;
            }
        }

        return new int[]{number, order};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new 영어_끝말잇기().solution(2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"})));
    }
}
