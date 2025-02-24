import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 그래프 이용
// 컴퓨터 = 노드 -> N
// 연결되는 컴퓨터 쌍 = 간선의 수 -> M
// DFS문제 !

// 1 -> 2 -> 3
// 1 -> 5
// 5 -> 2 5 -> 6
// 4 -> 7
public class Main {
    static int N, M;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int computer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        // 그래프 초기화
        graph = new ArrayList[N + 1];
        // 연결 리스트 초기화
        for (int i = 1; i <= N ; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            graph[u].add(n);
            graph[n].add(u);
        }
        visited = new boolean[N + 1];
        computer = 0;
        dfs(1);
        System.out.print(computer);
    }

    static void dfs(int depth){
        visited[depth] = true;

        for (int next : graph[depth]) {
            if (!visited[next]) {
                computer++;
                dfs(next);
            }
        }
    }
}