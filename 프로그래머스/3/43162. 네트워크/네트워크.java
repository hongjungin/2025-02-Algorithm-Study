import java.util.*;

class Solution {
    
    static boolean[] visited;
    static int n;
    static int[][] computers;
    
    public int solution(int ninput, int[][] computer) {
        int answer = 0;
        n = ninput;
        computers = computer;
        // 초기화
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            // 아직 방문을 안했으면
            if (!visited[i]) {
                // dfs 돌려
                dfs(i);
                answer++;
            }   
        } 
        return answer;
    }
    
    static void dfs(int depth) {
        // System.out.println("visit" + depth);
        visited[depth] = true;
        
        for (int next = 0; next < n; next++) {
            if (computers[depth][next] == 1 && !visited[next]) {
                // System.out.println(depth + " -> " + next);
                dfs(next);
            }
        }
    }
}