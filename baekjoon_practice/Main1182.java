import java.util.*;
import java.io.*;

// 부분 집합 문제

public class Main1182 {

    static int N, S, count;
    static int[] arr;
    static boolean[] selected;
    public static void main (String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        selected = new boolean[N];
        count = 0;
        subset(0, 0);
        if (S == 0) count -= 1;
        System.out.println(count);
    }

    private static void subset(int depth, int sum) {

        if (depth == N) {
            if (sum == S) count++;

            return;
        }

        selected[depth] = true;
        subset(depth + 1, sum + arr[depth]);
        selected[depth] = false;
        subset(depth + 1, sum);

    }
}
