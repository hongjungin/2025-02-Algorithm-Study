import java.util.*;
// 원형 -> 선형으로 바꾸자
// 선형으로 바꿀 경우 양 끝 인덱스는 인접한 것이라서 처리해줘야 함
// 1. 맨 앞 완전 배제 2. 맨 끝 완전 배제 -> case 2개로 나눠
// 반복되는 선택 -> 턴다 & 안턴다 이진 선택 -> dp 떠올리기
// 전 집(i-1)을 터냐, 전전 집(i-2)을 털고 지금 집을 터는게 이득이냐 판단
// i = 2 일 때 부터 시작하는게 좋을 듯

class Solution {
    static int[] dp1;
    static int[] dp2;
    public int solution(int[] money) {
        int answer = 0;
        
        int size = money.length;
        dp1 = new int[size + 1];
        dp2 = new int[size + 1];
        
        if (size == 1) return money[0];
        if (size == 2) return Math.max(money[0], money[1]);
        
        // 맨 앞 배제
        dp1[1] = money[1];
        dp1[2] = Math.max(money[1], money[2]);
        for (int i = 3; i < size; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i-2] + money[i]);
        }
        
        // 맨 끝 배제
        dp2[0] = money[0];
        dp2[1] = Math.max(money[1], money[0]);
        for (int i = 2; i < size - 1; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i-2] + money[i]);
        }
        
        answer = Math.max(dp1[size-1], dp2[size-2]);
        
        return answer;
    }
}