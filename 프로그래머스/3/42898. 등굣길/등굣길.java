import java.util.*;

// 오른쪽과 아래만 움직여, 최단 거리로 학교감
// 행 1 열 1인 곳은 갈 수 있는 가짓수를 하라고 하고
// 웅덩이는 0으로 채움.

// 행 열 헷갈릴 수 있음 주의 *

class Solution {
    
    static int[][] dp;
    static boolean[][] isPuddle;
    
    public int solution(int m, int n, int[][] puddles) {
        int MOD = 1_000_000_007;
        
        dp = new int[n+1][m+1];
        isPuddle = new boolean[n+1][m+1];
        
        for (int i = 0; i < puddles.length; i++) {
            int x = puddles[i][0];
            int y = puddles[i][1];
            
            isPuddle[y][x] = true;
        }
        
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                
                if (i == 1 && j == 1) {
                    dp[i][j] = 1;
                    continue;   
                }
                
                if (isPuddle[i][j]) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i-1][j] % MOD + dp[i][j-1] % MOD;
                }
            }
        }
        
        
        return dp[n][m] % MOD;
    }
}