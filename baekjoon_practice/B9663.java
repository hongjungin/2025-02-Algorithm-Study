import java.io.*;
import java.util.*;

public class B9663 {

    static int N;
    static boolean[][] board;
    static int count;

    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new boolean[N][N];
        count = 0;

        backTracking(0);

        System.out.println(count);
    }

    private static void backTracking(int row) {

        // 1. 종료 조건 : 모든 행을 다 채우면? -> count 증가 후 리턴
        if (row == N) {
            count++;
            return;
        }

        // 2. 현재 행에서 열을 돌며 퀸 배치
        for (int col = 0; col < N; col++) {
            // 3. 유효성 검사 -> 놓을 수 있어? 서로 공격 안해?
            if (isSafe(row, col)) {
                // 4. 퀸 놓기
                board[row][col] = true;
                // 5. 다음 행으로 재귀 호출
                backTracking(row + 1);
                // 6. 백트래킹
                board[row][col] = false;
            }
        }
    }

    private static boolean isSafe (int row, int col) {
        // 세로 체크
        for (int i = row -1; i >= 0; i--) {
            if (board[i][col]) {
                // 퀸이 있어
                return false;
            }
        }
        // 왼쪽 위 대각선 체크
        int r = row - 1;
        int c = col - 1;

        while (r >= 0 && c >= 0) {
            if (board[r][c]) {
                return false;
            }
            r--;
            c--;
        }

        // 오른쪽 위 대각선 체크
        int r2 = row - 1;
        int c2 = col + 1;

        while (r2 >= 0 && c2 < N) {
            if (board[r2][c2]) {
                return false;
            }
            r2--;
            c2++;
        }

        return true;
    }
}
