import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int n = citations.length;
        
        // 내림차순
        Arrays.sort(citations);
        
        int h = n;
        int count = 0;
        
        while (h != count) {
            for (int i = 0; i < n; i++) {
                if (citations[i] >= h) {
                    count = n - i;
                    break;
                }
            }
            
            if (h <= count) break;
            
            count = 0;
            h--;
        }
        
        answer = h;
        
        return answer;
    }
}