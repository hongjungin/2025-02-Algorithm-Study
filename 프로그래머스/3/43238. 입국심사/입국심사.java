import java.util.*;

// 사람 10억명
// 심사 걸리는 시간 1분 이상 10억 이하

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < times.length; i++) {
            if (max < times[i]) max = times[i];
        }
        
        long left = 1;
        long right = (long) max * n;
        long mid = 0L;
        while (left <= right) {
            mid = (left + right) / 2;
            long t = 0L;
            for (int time : times) {
                t += mid / time;
                
                // 이미 목표한 것보다 커? 그럼 계산할 필요 없음
                if (t >= n) {
                    break;
                }
            }
            
            if (t >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
}