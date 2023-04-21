package hash;

import java.util.HashMap;
import java.util.Map;

public class 완주하지_못한_선수 {
    
    // {"mislav", "stanko", "mislav", "ana"}
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> participantMap = new HashMap<>();

        for (String key : participant) {
            participantMap.put(key, participantMap.getOrDefault(key, 0) + 1);
        }

        for (String key : completion) {
            participantMap.put(key, participantMap.get(key) - 1);
            if (participantMap.get(key) == 0) {
                participantMap.remove(key);
            }
        }

        for (String key : participantMap.keySet()) {
            answer = key;
        }

        return answer;
    }

    // {"mislav", "stanko", "mislav", "ana"}
    // {"stanko", "ana", "mislav"}
    public static void main(String[] args) {
        System.out.println(new 완주하지_못한_선수().solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"}));
    }
}
