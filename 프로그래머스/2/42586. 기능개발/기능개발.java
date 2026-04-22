import java.util.*;

class Solution {
    static Queue<Integer> days;

    public int[] solution(int[] progresses, int[] speeds) {
        
        days = new ArrayDeque<>();
        
        int index = 0;
        
        for (int p : progresses) {
            int d = (100 - p) / speeds[index];
            
            if ((100 - p) % speeds[index] > 0) {
                d += 1;
            }
            days.offer(d);
            
            index++;
        }
        
        List<Integer> resultList = new ArrayList<>();        

        while (!days.isEmpty()) {
            
            int now = days.poll();
            int count = 1;
            
            while (!days.isEmpty() && days.peek() <= now) {
            days.poll();
            count++;
            }
            
            resultList.add(count);
        }
        
        int[] answer = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            answer[i] = resultList.get(i);
        }
    return answer;
    }
}