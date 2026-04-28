import java.util.*;
// 아이디 길이 3 이상 15 이하
// .은 처음고 끝 X 연달아 X

class Solution {
    public String solution(String new_id) {
        // 1단계  
        String s = new_id.toLowerCase();
        
        // 2단계 : 특정이 아닌 것 다 제외
        StringBuilder sb = new StringBuilder();
        String s2 = s.replaceAll("[^a-z0-9-_.]", "");
        
        // 3단계 .2개 이상 연달아 -> 1개로
        sb.append(s2.replaceAll("\\.{2,}", "."));
        
        // 4단계
        if((sb.toString()).startsWith(".")) {
            sb.deleteCharAt(0);
        } 
        if ((sb.toString()).endsWith(".")) {
            sb.deleteCharAt(sb.length()-1);
        }
        
        // 5단계
        if(sb.length() == 0) {
            sb.append("a");
        }
        
        // 6단계
        if (sb.length() >= 16) {
            sb.setLength(15);
            if (sb.toString().endsWith(".")) {
                sb.deleteCharAt(14);   
            }
        }
        
        // 7단계
        if (sb.length() <= 2) {
            while(sb.length() < 3) {
                sb.append(sb.charAt(sb.length()-1));
            }
        }
        
        return sb.toString();
    }
}