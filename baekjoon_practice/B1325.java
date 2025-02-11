import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1325 {
    // 5 4
    // 3 1 : 3 -> 1
    // 3 2 : 3 -> 2
    // 4 3 : 4 -> 3
    // 5 3 : 5 -> 3
    // 3 -> 1 , 2
    // 5 -> 3 -> 1 , 2

    // dfs 로 접근

    static int N;
    static int M;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] result;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        // 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        // 입력 받기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            // B -> A
            graph.get(B).add(A);
        }
        // 노드 1부터 시작하니까 N+1
        result = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            result[i] = dfs(i);
        }

        int maxComs = -1;

        for (int i = 0; i <= N; i++) {
            maxComs = Math.max(maxComs, result[i]);
        }

        for (int i = 1; i <= N; i++) {
            if (result[i] == maxComs) {
                System.out.print(i + " ");
            }
        }
    }
    static int dfs(int node) {
        visited[node] = true;
        int count = 1;

        for (int next : graph.get(node)) {
            if (!visited[next]) {
                count += dfs(next);
            }
        }
        return count;
    }
}
