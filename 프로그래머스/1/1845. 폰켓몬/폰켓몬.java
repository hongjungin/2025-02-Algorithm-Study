import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int size = nums.length / 2;
        int answer = 0;
        Set<Integer> poketmon = new HashSet<>();
        
        for (int n : nums) {
            poketmon.add(n);
            
        }
        
        int pick = poketmon.size();
        if (pick > size) answer = size;
        else if (pick <= size) answer = pick;
        
        return answer;
    }
}