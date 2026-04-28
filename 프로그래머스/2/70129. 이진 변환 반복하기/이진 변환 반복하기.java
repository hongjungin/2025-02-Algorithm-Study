import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        int count = 0;
        int deleteZero = 0;
        int len = s.length();
        
        while(len != 1) {
            
            s = s.replaceAll("0", "");
            deleteZero += (len - s.length());
            count++;
            
            // 2진 변환
            int num = s.length();
            StringBuilder sb = new StringBuilder();
            while(num > 0) {
                sb.append(num % 2);
                num /= 2;
            }
            
            s = sb.reverse().toString();
            
            len = s.length();
            
        }
        
        answer[0] = count;
        answer[1] = deleteZero;
        return answer;
    }
}