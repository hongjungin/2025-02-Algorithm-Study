import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        
        Set<Integer>[] dp = new HashSet[9];
        for (int i = 1; i <= 8; i++) {
            dp[i] = new HashSet<>();
        }
        
        dp[1].add(N);
        if (N == number) return 1;
        
        for (int i = 2; i <= 8; i++) {
            
            // 이어 붙이기 넣음
            int concat = 0;
            for (int j = 0; j < i; j++) concat = concat * 10 + N;
            dp[i].add(concat);
        
            for (int k = 1; k < i; k++) {
                for (int a : dp[k]) {
                    for (int b : dp[i - k]) {
                        dp[i].add(a+b);
                        dp[i].add(a-b);
                        dp[i].add(b-a);
                        dp[i].add(a*b);
                        
                        if(b != 0) dp[i].add(a/b);
                        if(a != 0) dp[i].add(b/a);
                    }
                }
            }
            
            for (int num : dp[i]) {
                if (num == number) return i;
            }
            
        }
        
        return -1;
    }
}