import java.util.*;

// 1번 [1, 2, 3, 4, 5] 반복
// 2번 [2, 1, 2, 3, 2, 4, 2, 5] 반복
// 3번 [3, 3, 1, 1, 2, 2, 4, 4, 5, 5] 반복

class Solution {
    public int[] solution(int[] answers) {
        
        int[] s1 = {1, 2, 3, 4, 5};
        int[] s2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] s3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] s = new int[3];
        
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == s1[i % 5]) {
                s[0] += 1;
            }
            
            if (answers[i] == s2[i % 8]) {
                s[1] += 1;
            }
            
            if (answers[i] == s3[i % 10]) {
                s[2] += 1;
            }
        }
        
        int maxScore = Math.max(s[0], Math.max(s[1], s[2]));

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            if (s[i] == maxScore) {
                list.add(i + 1);
            }
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}