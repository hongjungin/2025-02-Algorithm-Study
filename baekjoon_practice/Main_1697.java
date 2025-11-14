import java.util.*;
import java.io.*;

// 최소 ~ .. + 모든 간선 비용이 1 이므로 -> bfs로 풀자 !

public class Main_1697 {

    static int N, K, result;
    static boolean[] visited;

    public static void main (String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[100_001];
        result = 0;
        bfs(N, 0);

        System.out.println(result);
    }

    static void bfs (int start, int depth) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{start, depth});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] curQ = queue.poll();
            int cur = curQ[0];
            int dist = curQ[1];

            if (cur == K) {
                result = dist;
                break;
            }

            int[] next = {cur + 1, cur - 1, cur * 2};

            for (int nx : next) {
                if (nx >= 0 && nx < 100001 && !visited[nx]) {
                    queue.offer(new int[]{nx, dist+1});
                    visited[nx] = true;
                }
            }
        }
    }
}
