import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        int start = 0;
        int end = 0;
        int sum = sequence[0];
        int min = Integer.MAX_VALUE;
        
        while (start <= end && end <= sequence.length) {
            
            if (sum == k) {
                if ((end - start + 1) < min) {
                    answer[0] = start;
                    answer[1] = end;
                    min = end - start + 1;
                } 
                
                sum -= sequence[start];
                start++;
                 
            } else if (sum > k) {
                sum -= sequence[start];
                start++;
            } else {
                end++;
                if (end < sequence.length) {
                    sum += sequence[end];   
                }
            }
            
        }
        
        return answer;
    }
}