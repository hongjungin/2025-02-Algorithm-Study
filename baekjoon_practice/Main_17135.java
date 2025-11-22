import java.util.*;
import java.io.*;

public class Main_17135 {

    static int N, M, D;
    static int[][] board;
    static int[] archers;
    static int answer;

    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        archers = new int[3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combi(0,0);

    }

    static void combi(int depth, int start) {
        if (depth == 3) {

            int[][] temp = copyBoard(board);

            int killed = simulate(temp);

            return;
        }

        for (int i = start; i < M; i++) {
            archers[depth] = i;
            combi(depth+1, i + 1);
        }
    }

    static int[][] copyBoard(int[][] src) {
        int[][] dest = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dest[i][j] = board[i][j];
            }
        }

        return dest;
    }

    static int simulate(int[][] map) {
        int killCount = 0;

        
    }
}
