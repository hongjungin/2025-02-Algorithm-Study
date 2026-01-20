import java.util.*;
import java.io.*;

// 모든 정점 연결 + 가중치 합 최소 -> MST
// 모든 정점 연결해야하니까 visited 필요

public class B1197 {

    static int V, E;
    static int[][] graph;
    static int[] minCost;
    static boolean[] visited;
    static int min;
    static long answer;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new int[V+1][V+1];

        minCost = new int[V+1];
        for (int i = 2; i <= V; i++) {
            minCost[i] = Integer.MAX_VALUE;
        }

        visited = new boolean[V+1];

        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a][b] = c;
            graph[b][a] = c;
        }

        answer = 0;

        for (int i = 1; i <= V; i++) {
            // 최소 찾기
            int v = -1;
            min = Integer.MAX_VALUE;

            for (int j = 1; j <= V; j++) {
                if (!visited[j] && minCost[j] < min) {
                    min = minCost[j];
                    v = j;
                }
            }

            // visited 찍기
            visited[v] = true;
            answer += minCost[v];

            // minCost 갱신
            for (int u = 1; u <= V; u++) {
                if(!visited[u] && graph[u][v] < minCost[u]) {
                    minCost[u] = graph[u][v];
                }
            }
        }

        System.out.println(answer);

    }
}
