import java.util.*;

// k 는 10억 이하

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for (int s : scoville) {
            queue.add(s);
        }
        
        while (queue.peek() < K && queue.size() >= 2) {
            int first = queue.poll();
            int second = queue.poll();
            int newFood = first + second * 2;
            answer++;
            
            queue.add(newFood);
        }
        
        if (queue.poll() < K) {
            answer = -1;
        }
        
        return answer;
    }
}