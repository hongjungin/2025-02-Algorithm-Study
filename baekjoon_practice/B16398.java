import java.io.*;
import java.util.*;

public class B16398 {

    static int N;
    static int[][] planet;
    static boolean[] visited;
    static int[] minCost;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        planet = new int[N+1][N+1];
        visited = new boolean[N+1];
        minCost = new int[N+1];
        for (int i = 2; i <= N; i++) {
            minCost[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                planet[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long answer = 0;

        for (int i = 1; i <= N; i++) {

            // v = minCost 최소인 미방문 정점 찾기
            int v = -1;
            int min = Integer.MAX_VALUE;

            for (int j = 1; j <= N; j++) {
                if(!visited[j] && minCost[j] < min) {
                    min = minCost[j];
                    v = j;
                }
            }

            visited[v] = true;

            answer += minCost[v];

            for (int u = 1; u <= N; u++) {
                if(!visited[u] && planet[v][u] < minCost[u]) {
                    minCost[u] = planet[v][u];
                }
            }
        }

        System.out.println(answer);

    }
}
