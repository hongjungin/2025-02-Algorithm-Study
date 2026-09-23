import java.util.*;

// 바로 앞이나 바로 뒤에만 빌려줄 수 있음

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        int[] students = new int[n];
        Arrays.fill(students, 1);
        
        for (int i = 0; i < lost.length; i++) {
            students[lost[i] - 1] -= 1;
        }
        
        for (int i = 0; i < reserve.length; i++) {
            students[reserve[i] - 1] += 1;
        }
        
        // 1이면 여유분 있음. 0이면 내꺼만 있어. -1이면 잃어버림.
        
        for (int i = 0; i < n; i++) {
            
            if (students[i] == 0) { // 체육복 잃어버리면
                // 앞에 애한데 먼저 물어보기 -> 그리디
                if (i > 0 && students[i - 1] == 2) {
                    students[i - 1]--;
                    students[i]++; 
                } else if (i + 1 < n && students[i + 1] == 2) {
                    students[i + 1]--;
                    students[i]++;
                }
            } 
        }
        
        for (int i = 0; i < n; i++) {
            if(students[i] > 0) {
                answer++;
            }
        }
        
        return answer;
    }
}