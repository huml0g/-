package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class 위장 {

    // {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}
    // yellow_hat + blue_sunglasses
    // green_turban + blue_sunglasses
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> clothesMap = new HashMap<>();

        // hashmap을 이용하여 각 의상 종류에 해당하는 의상 수를 계산합니다.
        for(int i = 0; i < clothes.length; i++) {
            String key = clothes[i][1];
            clothesMap.put(key, clothesMap.getOrDefault(key, 0) + 1);
        }

        // 의상 종류별로 (의상 수 + 1)를 곱한 값을 모두 곱해줍니다.
        // (의상 수 + 1)을 하는 이유는 해당 종류의 의상을 입지 않는 경우를 추가해준 것입니다.
        // 해시맵 clothesMap에는 의상 종류별로 해당 종류의 의상이 몇 개 있는지가 저장되어 있습니다.
        // 예를 들어, clothesMap이 아래와 같다면,
        // json
        // Copy code
        // { "headgear" : 2, "eyewear" : 1 }
        // headgear 종류의 의상이 2개, eyewear 종류의 의상이 1개 있다는 뜻입니다.
        // 그렇다면 이제 이 의상 중에서 최소 하나는 반드시 입어야 합니다. 따라서 의상을 선택하는 경우의 수는 각 종류별 의상 개수에 1을 더한 값을 서로 곱한 것입니다.
        // 여기서 1을 더해주는 이유는 해당 종류의 의상을 입지 않는 경우도 포함되기 때문입니다. 예를 들어, 위의 clothesMap에서 2개의 headgear와 1개의 eyewear가 있다면,
        // 이 중에서 최소 하나의 의상을 선택하되 headgear를 선택할 경우의 수는 (2+1) = 3가지이고, eyewear를 선택할 경우의 수는 (1+1) = 2가지입니다.
        // 그러므로 모든 경우의 수는 3 x 2 = 6이 됩니다.
        // 이를 코드로 구현하면 위와 같이 for-each 루프를 사용하여 해시맵의 각 키(key)에 대해 해당 키의 값(value)에 1을 더하고 이 값을 answer에 곱해주는 방식으로 계산합니다.
        for(Integer value : clothesMap.values()) {
            answer *= value + 1;
        }

        // 모든 종류의 의상을 입지 않는 경우를 빼줍니다.
        return answer - 1;
    }

    public static void main(String[] args) {
        System.out.println(new 위장().solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
    }
}
