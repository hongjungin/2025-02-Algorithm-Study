import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        
        Map<Integer, Integer> cur = new HashMap<>();
        cur.put(0, 1); //초깃값
        
        for(int x : numbers) {
            Map<Integer, Integer> next = new HashMap<>();
            
            for (Map.Entry<Integer, Integer> e : cur.entrySet()) {
                int sum = e.getKey();
                int cnt = e.getValue();
                
                int a = sum + x;
                next.put(a, next.getOrDefault(a, 0) + cnt);
                
                int b = sum -x;
                next.put(b, next.getOrDefault(b, 0) + cnt);
            }
            
            cur = next;
        }
        
        return cur.getOrDefault(target, 0);
    }
}