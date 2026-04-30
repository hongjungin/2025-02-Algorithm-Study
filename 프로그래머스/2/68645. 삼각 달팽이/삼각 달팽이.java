import java.util.*;

class Solution {

    // 아래 -> 오른쪽 -> 대각선 반복 !
    static int[] dr = {1, 0, -1};
    static int[] dc = {0, 1, -1};
    
    public int[] solution(int n) {
        int[] answer = new int[n*(n+1)/2];
        int[][] board = new int[n][n];
        
        int input = 1;
        int dir = 0;
        int moveCount = n;
        int r = -1;
        int c = 0;
        
        // n번 꺾어 -> 그만큼 써클을 돌아
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < moveCount; j++) {
                r = r + dr[dir];
                c = c + dc[dir];
                
                board[r][c] = input;
                input++;
            }
            moveCount--;
            dir = (dir + 1) % 3; 
        }
        
        int index = 0; 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] > 0) {
                    answer[index] = board[i][j];
                    index++;
                }
            }
        }
        
        return answer;
    }
}