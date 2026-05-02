import java.util.*;

// 이게 순서가 중요한거 잖아
// 순열처럼 생각해도 되나?

class Solution {
    static boolean[] visited;
    static int count;
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        visited = new boolean[dungeons.length];
        count = Integer.MIN_VALUE;
        dfs(0, k, dungeons);
        answer = count;
        return answer;
    }
    
    private static void dfs (int depth, int k, int[][] dungeons) {
        count = Math.max(count, depth);
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(depth + 1, k - dungeons[i][1], dungeons);
                visited[i] = false;
            }
        }
        
        
    }
}