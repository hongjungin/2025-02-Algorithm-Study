import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        
        int n = elements.length;
        Set<Integer> result = new HashSet<>();
        
        for (int start = 0; start < n; start++) {
            int sum = 0;
            
            for (int len = 0; len < n; len++) {
                sum += elements[(start + len) % n];
                result.add(sum);
            }
        }
        
        answer = result.size();
        return answer;
    }
}