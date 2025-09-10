import java.util.*;
import java.io.*;

// 가로 세로 100 도화지
// 이 도화지에 가로 세로 10 색종이 붙여
// 색종이가 붙은 넓이 구하는 ..
// 격자를 칸 처럼 칠하냐 안칠하냐

public class Main {
    static int N;
    static int x , y;
    static boolean[][] board;
    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new boolean[101][101];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            for (int j = x; j < x + 10; j++) {
                for (int k = y; k < y + 10; k++) {
                    board[j][k] = true;
                }
            }
        }

        int weight = 0;

        for (int i = 1; i < 101 ; i++) {
            for (int j = 1; j < 101 ; j++) {
                if (board[i][j]) weight++;
            }
        }

        System.out.println(weight);
    }
}
