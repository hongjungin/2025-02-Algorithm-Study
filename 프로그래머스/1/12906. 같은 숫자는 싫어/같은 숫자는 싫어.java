import java.util.*;

// 연속적으로 나타나는 숫자는 하나만 두고 다 제거
// 남은 수 반환할 때 arr 언소들 순서 유지
// arr 크기 100만 이하

public class Solution {
    
    static Queue<Integer> queue;
    static int now;
    
    public int[] solution(int []arr) {
        
        queue = new ArrayDeque<>();
        now = arr[0];
        queue.add(now);
        
        for (int i = 1; i < arr.length; i++) {
            
            if(!queue.isEmpty()) {
                if (now != arr[i]) {
                    queue.add(arr[i]);
                    now = arr[i];
                }
            }
            
        }
        
        int[] answer = new int[queue.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = queue.poll();    
        }
        
        return answer;
    }
}