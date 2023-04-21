package 연습문제;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 광물_캐기 {

/*    public int solution(int[] picks, String[] minerals) {
        // IntStream을 사용해 범위를 지정해가며 minerals 배열을 잘라낸다.
        // 잘라낸 배열의 첫 5개 문자열을 이용해 새로운 배열을 생성하고 각 문자열의 점수를 계산하여 저장한다.
        // 마지막으로 모든 배열을 score로 변환하여 반환한다.
        return IntStream.iterate(0, i -> i < Math.min(minerals.length, Arrays.stream(picks).sum() * 5), i -> i + 5)
                .mapToObj(i -> Arrays.stream(Arrays.copyOfRange(minerals, i, Math.min(i + 5, minerals.length)))
                        .mapToInt(s -> s.charAt(0) == 'd' ? 25 : s.charAt(0) == 'i' ? 5 : 1).toArray())

                // score가 가장 높은 배열 순으로 정렬한다.
                .sorted((a, b) -> Arrays.stream(b).sum() - Arrays.stream(a).sum())

                // picks 배열의 값을 차례로 비교하여 적절한 값을 선택하여 score를 계산한다.
                // 계산된 score를 반환한다.
                .mapToInt(arr -> {
                    int n = picks[0]-- > 0 ? 25 : picks[1]-- > 0 ? 5 : 1;
                    return Arrays.stream(arr).map(i -> Math.max(i / n, 1)).sum();
                })
                .sum(); // 모든 score의 합을 반환한다.
    }*/

    public int solution(int[] picks, String[] minerals) {
        // totalPicks: 총 뽑기 횟수 (picks 배열의 합계 * 5)
        int totalPicks = Arrays.stream(picks).sum() * 5;
        // numMinerals: 실제로 뽑을 광물의 개수 (minerals 배열의 길이와 totalPicks 중 작은 값)
        int numMinerals = Math.min(minerals.length, totalPicks);
        // mineralsList: 5개씩 묶어서 광물의 점수를 저장하는 리스트
        List<int[]> mineralsList = new ArrayList<>();
        for (int i = 0; i < numMinerals; i += 5) {
            // 5개씩 묶어서 광물의 점수를 계산해서 mineralScores 배열에 저장
            int[] mineralScores = new int[5];
            for (int j = 0; j < 5 && i + j < numMinerals; j++) {
                String mineral = minerals[i + j];
                // 광물의 종류에 따라 점수를 계산 (diamond: 25, iron: 5, 그 외: 1)
                int score = mineral.charAt(0) == 'd' ? 25 : mineral.charAt(0) == 'i' ? 5 : 1;
                mineralScores[j] = score;
            }
            // mineralScores 배열을 mineralsList에 추가
            mineralsList.add(mineralScores);
        }
        // mineralsList를 광물의 점수 합계에 따라 내림차순으로 정렬
        mineralsList.sort((a, b) -> Arrays.stream(b).sum() - Arrays.stream(a).sum());
        // totalScore: 뽑은 광물들의 점수 총합
        int totalScore = 0;
        for (int[] mineralScores : mineralsList) {
            // n: 뽑은 횟수에 따라 광물의 점수를 계산하기 위한 상수
            int n = picks[0]-- > 0 ? 25 : picks[1]-- > 0 ? 5 : 1;
            // 광물 5개의 점수를 n으로 나눈 후 올림한 값을 합산하여 score에 저장
            int score = Arrays.stream(mineralScores).map(i -> (i + n - 1) / n).sum();
            // totalScore에 score를 더함
            totalScore += score;
        }
        // 뽑은 광물들의 점수 총합인 totalScore를 반환
        return totalScore;
    }

    public static void main(String[] args) {
        System.out.println(
            new 광물_캐기().solution(new int[]{0,1,1}, new String[]{"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"})
        );
    }
}
