package hash;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 베스트앨범 {

    static class Music implements Comparable<Music>{

        private final int played; // 재생 횟수
        private final int id; // 고유 ID
        private final String genre; // 장르

        public Music(String genre, int played, int id) {
            this.genre = genre;
            this.played = played;
            this.id = id;
        }

        @Override
        public int compareTo(Music other) {
            if(this.played == other.played) return this.id - other.id; // 재생 횟수가 같으면 id 순으로 오름차순 정렬
            return other.played - this.played; // 아니면 재생 횟수 순으로 내림차순 정렬
        }

        public String getGenre() {return genre;} // 장르 getter
    }

    public int[] solution(String[] genres, int[] plays) {
        // Music 객체 생성 후 Stream으로 변환
        return IntStream.range(0, genres.length)
                .mapToObj(i -> new Music(genres[i], plays[i], i))
                // 장르별로 Music 객체를 그룹핑한 Map을 생성
                .collect(Collectors.groupingBy(Music::getGenre))
                // 각 장르의 총 재생 횟수를 계산한 후, 장르별로 내림차순으로 정렬
                .entrySet().stream()
                .sorted((a, b) -> sum(b.getValue()) - sum(a.getValue()))
                // 각 장르에서 가장 재생 횟수가 높은 곡과 그 다음으로 재생 횟수가 높은 곡을 고르기 위해 Stream을 flatMap하여 2개씩 선택
                .flatMap(x -> x.getValue().stream().sorted().limit(2))
                // Music 객체에서 id 값만 추출한 뒤, int 배열로 변환하여 반환
                .mapToInt(x -> x.id).toArray();
    }

    // 재생 횟수의 합을 계산하는 메소드
    private int sum(List<Music> value) {
        int answer = 0;
        for (Music music : value) {
            answer += music.played;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(new 베스트앨범().solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500}))
        );
    }
}
