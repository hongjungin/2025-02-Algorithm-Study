import java.util.*;

class Solution {
    
    static int[][] board;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        board = new int[rows][columns];
        int num = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = num;
                num++;
            }
        }
        
        for (int j = 0; j < queries.length; j++) {
            int x1 = queries[j][0] - 1;
            int y1 = queries[j][1] - 1;
            int x2 = queries[j][2] - 1;
            int y2 = queries[j][3] - 1;
            
            int temp = board[x1][y1];
            int min = temp;
            
            // 아래 -> 위    
            for (int i = x1; i < x2; i++) {
                board[i][y1] = board[i+1][y1];
                min = Math.min(min, board[i][y1]);
            }
            // 오 -> 왼
            for (int i = y1; i < y2; i++) {
                board[x2][i] = board[x2][i+1];
                min = Math.min(min, board[x2][i]);
            }
            // 위 -> 아래
            for (int i = x2; i > x1; i--) {
                board[i][y2] = board[i-1][y2];
                min = Math.min(min, board[i][y2]);
            }
            // 왼 -> 오
            for (int i = y2; i > y1 + 1; i--) {
                board[x1][i] = board[x1][i-1];
                min = Math.min(min, board[x1][i]);
            }
            board[x1][y1+1] = temp;
            answer[j] = min;
        }
        
        
        return answer;
    }
}