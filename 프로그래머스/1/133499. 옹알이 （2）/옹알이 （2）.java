import java.util.*;

class Solution {
    
    static String[] can = {"aya", "ye", "woo", "ma"};
    
    public int solution(String[] babbling) {
        int answer = 0;
        
        for (int i = 0; i < babbling.length; i++) {
            String b = babbling[i];
            boolean canTalk = true;
            
            // 두 번 이상 연속 안돼
            for (int j = 0; j < 4; j++) {
                if (b.contains(can[j] + can[j])) {
                    canTalk = false;
                    break;
                }
            }
            
            // 여러 개 조합 가능 
            for (int j = 0; j < 4; j++) {
                if (b.contains(can[j])) {
                    b = b.replaceAll(can[j], " ");
                }
            }
            
            if (canTalk && b.trim().length() == 0) {
                answer++;
            }
                
        }
        
        return answer;
    }
}