import java.util.*;

class Solution {
    
    static int[] remainDays;
    
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        
        int len = progresses.length;
        remainDays = new int[len];
        
        for (int i = 0; i < len; i++) {
            
            int remain = 100 - progresses[i];
            
            remainDays[i] = (remain + speeds[i] - 1) / speeds[i];
            
        }
        
        int start = remainDays[0];
        int count = 1;
        for (int i = 1; i < len; i++) {
            if (remainDays[i] <= start) {
                count++;
            } else {
                answer.add(count);
                start = remainDays[i];
                count = 1;
            }
        }
        answer.add(count);
        
        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }
        
        return result;
    }
}