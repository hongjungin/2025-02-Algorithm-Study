import java.util.*;
import java.io.*;
import java.lang.*;

// 부분 수열의 합 -> 갯수 고정아님 subset?

public class B1182 {

    static int N, S, count;
    static boolean[] visited;
    static int[] arr;

    public static void main (String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        count = 0;
        subset(0, 0);
        if (S == 0) count--;
        System.out.println(count);
    }

    static void subset(int depth, int sum) {

        if (depth == N) {
            for (int i = 0; i < N; i++) {
                if(visited[i]) sum += arr[i];
            }

            if (sum == S) count++;
            return;
        }

        subset(depth + 1, sum + arr[depth]);
        subset(depth + 1, sum);
    }
}
