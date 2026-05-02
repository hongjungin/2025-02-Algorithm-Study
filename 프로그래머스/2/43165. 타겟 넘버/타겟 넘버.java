import java.util.*;

// 숫자의 순서는 그대로
// + 아니면 빼기 선택 
// 타겟 넘버가 되면 끝 -> dfs로 가능 순열 문제! -> 20개 정도면 충분히 가능

class Solution {
    static int answer;
    static int n;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        n = numbers.length; 
        
        dfs(0,0, numbers, target);
        
        return answer;
    }
    
    private static void dfs (int depth, int sum, int[] numbers, int target) {
        // 종료 조건
        if (depth == n) {
            if (sum == target) {
                answer++;
            }
            return;
        }
        
        // + 선택
        dfs(depth + 1, sum + numbers[depth], numbers, target);
        
        // - 선택
        dfs(depth + 1, sum - numbers[depth], numbers, target);
    }
}