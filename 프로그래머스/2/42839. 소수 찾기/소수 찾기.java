import java.util.*;

// 소수 만들기 ... 
// 부분순열?로 나올 수 있는 거 다 만들고 -> 중복이 되어야 해 
// 소수인지 아닌지 판별하는 방식으로 구현해야하나?
// 소수인지 아닌지는 어떻게 알지
// 자기 자신 루트 씌워서 
// for 문 돌리고 1말고 자신을 나눌 수 없어야해? -> 이게 맞나

// 부분 집합은 선택할지 말지를 결정해야힘

class Solution {
    static char[] arr;
    static int N;
    static boolean[] visited;
    static Set<Integer> nums;
    
    public int solution(String numbers) {
        int answer = 0;
        
        N = numbers.length();
        
        arr = numbers.toCharArray();
        
        // System.out.println(Arrays.toString(arr));
        // System.out.println(N);
        
        visited = new boolean[N];
        nums = new HashSet<>();
        perm(0, "");
        
        
        for (int num : nums) {
            
            if (num == 0) {
                continue;
            } else if ( num == 1) {
                continue;
            } else {
                boolean isPrime = true;
                for (int i = 2; i < Math.abs(num); i++) {
                
                    if (num % i == 0) {
                        isPrime = false;
                    }
                }
            
                if (isPrime) {
                    answer++;
                }
            }
            
            
        }
        return answer;
    }
    
    static void perm(int depth, String cur) {
        
        if (depth > 0) {
            nums.add(Integer.parseInt(cur));
        }
        
        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            
            visited[i] = true;
            perm(depth + 1, cur + arr[i]);
            visited[i] = false;
        }
        
        
    }
}