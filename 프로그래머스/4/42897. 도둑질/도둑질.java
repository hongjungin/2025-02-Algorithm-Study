import java.util.*;

// money 의 인덱스를 집 번호라고 생각할 때
// 1번과 N번이 다르지 않게 선택하면 되겠다 -> dp 배열 2개 두기

class Solution {
    
    static int[] dp1;
    static int[] dp2;
    
    public int solution(int[] money) {
        int answer = 0;
        
        int N = money.length;
        
        // 1번 집 털어 -> 마지막 무조건 털면 안돼
        dp1 = new int[N];
        
        dp1[0] = money[0];
        dp1[1] = Math.max(money[0], money[1]);
        
        for (int i = 2; i < N - 1; i++) {
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + money[i]);
        }
        
        // 1번 집 안털어
        dp2 = new int[N];
        
        dp2[0] = 0;
        dp2[1] = money[1];
        
        for (int i = 2; i < N; i++) {
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + money[i]);
        }
        
        return Math.max(dp2[N-1], dp1[N-2]);
    }
}