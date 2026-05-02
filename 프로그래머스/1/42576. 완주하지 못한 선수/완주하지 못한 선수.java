import java.util.*;
// 10만 * 10만 -> 시간초과남 100억
// 중복되는게 있으므로 묶어서 몇명인지 세고 차감하는 방식
// Set 하면 안됨. 그럼 갯수 확인 불가

class Solution {
    
    static HashMap<String, Integer> map;
    
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        map = new HashMap<>();
        
        for (int i = 0; i < participant.length; i++) {
            map.put(participant[i], map.getOrDefault(participant[i], 0) + 1);
        }
        
        for (int i = 0; i < completion.length; i++) {
            int num = map.get(completion[i]);
            if (num > 0) {
                map.put(completion[i], num - 1);
            }
        }
        
        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                answer = key;
                break;
            }
        }
        
        
        return answer;
    }
}