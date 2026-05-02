import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0] - 1;
            int end = commands[i][1] - 1;
            int index = commands[i][2];
            
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            
            for (int j = start; j <= end; j++) {
                queue.add(array[j]);
            }
            
            if (index == 1) {
                answer[i] = queue.poll();
            } else if (!queue.isEmpty()) {
                for (int j = 0; j < index - 1; j++) {
                    queue.poll();
                }
                answer[i] = queue.poll();
            }
            
        }
        
        return answer;
    }
}