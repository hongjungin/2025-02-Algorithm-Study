import java.util.*;
import java.io.*;

// dp 인데 .. 몇번에 거쳐 이 값이 왔는지 저장해야함
// 그래서 2차원 배열 쓰임.

public class Main_5557 {

    static int N;
    static int[] input;
    static long result;
    static long[][] dp;

    public static void main (String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        input = new int[N];

        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        result = 0L;

        dp = new long[N][21];
        dp[0][input[0]] = 1;

        for (int i = 1; i < N - 1; i++) {

            for (int v = 0; v <= 20; v++) {

                if (dp[i - 1][v] == 0) continue;

                int next1 = v + input[i];
                int next2 = v - input[i];

                if (next1 >= 0 && next1 <= 20) {
                    dp[i][next1] += dp[i-1][v];
                }

                if (next2 >= 0 && next2 <= 20) {
                    dp[i][next2] += dp[i-1][v];
                }

            }

        }

        System.out.println(dp[N-2][input[N-1]]);

    }
}
