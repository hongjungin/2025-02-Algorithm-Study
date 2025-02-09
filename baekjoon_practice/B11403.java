import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11403 {
    static int N;             // 노드의 개수
    static int[][] graph;     // 입력 그래프
    static int[][] result;    // 결과 저장할 배열
    static boolean[] visited; // 방문 여부 체크할 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];
        result = new int[N][N];

        // 그래프 입력 받기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // DFS 탐색 시작
        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            // i에서 갈 수 있는 노드 찾기
            dfs(i,i);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void dfs(int start, int node) {
        for (int next = 0; next < N; next++) {
            if (graph[node][next] == 1 && !visited[next]) {
                visited[next] = true;
                result[start][next] = 1;
                dfs(start, next);
            }
        }
    }
}
