import java.util.*;
// m : 가로 -> 열
// n : 세로 -> 행
class Solution {
    static int[][] dp;
    static final int MOD = 1_000_000_007;
    static boolean[][] water;
    
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        dp = new int[n+1][m+1];
        water = new boolean[n+1][m+1];
        
        for (int[] p : puddles) {
            int x = p[0];
            int y = p[1];
            
            water[y][x] = true;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                
                if (water[i][j]) {
                    dp[i][j] = 0;
                    continue;
                }
                
                if(i == 1 && j == 1) {
                    dp[i][j] = 1;
                    continue;
                }
                
                int down = (j > 1) ? dp[i][j-1] : 0;
                int right = (i > 1) ? dp[i-1][j] : 0;
                
                dp[i][j] = (int)((down+right)%MOD); 
            }
        }
               
        return dp[n][m];
    }
}