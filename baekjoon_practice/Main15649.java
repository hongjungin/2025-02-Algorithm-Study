import java.io.*;
import java.util.*;

public class Main15649 {

    static int N, M;
    static boolean[] visited;
    static int[] result;
    static StringBuilder sb;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        result = new int[M];
        sb = new StringBuilder();
        dfs(0);

        System.out.println(sb);
    }

    private static void dfs (int depth) {
        if (depth == M) {
            for (int val : result) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                result[depth] = i + 1;
                visited[i] = true;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}
