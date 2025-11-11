import java.util.*;

// 정렬 -> 인덱스로 끊어서 그 안에 최소 를 구하기

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        Arrays.sort(score);
        
        int start = score.length % m;
        
        for (int i = start; i < score.length; i += m) {
            answer += score[i] * m;
        }
        
        return answer;
    }
}