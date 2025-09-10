import java.util.*;
// 문자열로 char 배열로 만들어야하나?
// 아님 문자 그대로 처리가 되나?
// String 의 replaceAll 을 쓰자 
class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        String s = (new_id == null) ? "" : new_id;
        
        // 1단계 대문자 -> 소문자
        s = s.toLowerCase();
        
        // 2단계 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거
        s = s.replaceAll("[^a-z0-9-_.]", "");
        
        // 3단계 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)
        // 2번 이상을 어떻게 처리하지? 
        s = s.replaceAll("[.]+", ".");
        
        // 4단계 마침표(.)가 처음이나 끝에 위치한다면 제거
        if (s.startsWith(".")) s = s.substring(1);
        if (s.endsWith(".")) s = s.substring(0, s.length() - 1);
        
        
        // 5단계 빈 문자열이라면, new_id에 "a"를 대입합니다.
        if (s.isEmpty()) s = "a";
        
        // 6단계 길이가 16자 이상이면, 잘라    
        if (s.length() >= 16) s = s.substring(0, 15);
        if (s.endsWith(".")) s = s.substring(0, 14);
        
        // 7단계 길이가 2자 이하면 마지막 문자를 반복
        if (s.length() <= 2 && s.length() > 0) {
            while(s.length() < 3) {
                s = s + s.charAt(s.length() - 1);
            }
        }
        
        return s;
    }
}