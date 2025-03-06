import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, V;
    static List<Integer>[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());   // 노드의 개수
        M = Integer.parseInt(st.nextToken());   // 간선의 개수
        V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        visited = new boolean[N+1];

        dfs(V);
        System.out.println();
        Arrays.fill(visited, false);
        bfs(V);
    }

    static void dfs(int depth){
        visited[depth] = true;
        System.out.print(depth + " ");

        for (int next : graph[depth]) {
            if (!visited[next]){
                dfs(next);
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];

        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()){
            int node = queue.poll();
            System.out.print(node + " ");

            for (int next : graph[node]) {
                if (!visited[next]){
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}
