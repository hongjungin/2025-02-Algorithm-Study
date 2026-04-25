import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] operator;
    static int[] input;
    static int min, max;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        input = new int[N];
        operator = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            input[i] = num;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            int op = Integer.parseInt(st.nextToken());
            operator[i] = op;
        }

        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        dfs(0, input[0]);
        StringBuilder sb = new StringBuilder();
        sb.append(max).append("\n").append(min);
        System.out.println(sb);
    }

    private static void dfs(int depth, int cal) {

        if (depth == N - 1) {
            min = Math.min(min, cal);
            max = Math.max(max, cal);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;
                if (i == 0) {
                    dfs(depth + 1, cal + input[depth+1]);
                } else if (i == 1) {
                    dfs(depth + 1, cal - input[depth+1]);
                } else if (i == 2) {
                    dfs(depth + 1, cal * input[depth+1]);
                } else {
                    dfs(depth + 1, cal / input[depth+1]);
                }

                operator[i]++;
            }
        }

    }
}
