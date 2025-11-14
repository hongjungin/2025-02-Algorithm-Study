import java.util.*;
import java.io.*;

// 집이 N개
// 양 옆의 집 색이 달라야 함
// 원형 구조같은거네?

public class Main_17404 {

    static int N;
    static int[][] RGB;
    static int[][] dp;

    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        RGB = new int[N][3];


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                RGB[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = Integer.MAX_VALUE;

        for (int j = 0; j < 3; j++) {
            dp = new int[N][3];

            dp[0][j] = RGB[0][j];
            dp[0][(j+1)%3] = 1_000_000_000;
            dp[0][(j+2)%3] = 1_000_000_000;

            for (int i = 1; i < N; i++) {
                dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + RGB[i][0];
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + RGB[i][1];
                dp[i][2] = Math.min(dp[i-1][1], dp[i-1][0]) + RGB[i][2];
            }

            for (int i = 0; i < 3; i++) {

                if (i == j) continue;
                result = Math.min(result, dp[N-1][i]);
            }
        }
        System.out.println(result);

    }
}


