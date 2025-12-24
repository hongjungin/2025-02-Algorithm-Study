import java.util.*;
import java.io.*;

// 연결되면 바이러스 임
// 그래프 탐색 문제

public class Main2606 {

    static int com, N, virus;
    static List<List<Integer>> computers;
    static boolean[] visited;

    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        com = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());

        computers = new ArrayList<>();
        visited = new boolean[com + 1];

        for (int i = 0; i <= com; i++) {
            computers.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            computers.get(a).add(b);
            computers.get(b).add(a);
        }

        virus = 0;
        dfs(1);
        System.out.println(virus);
    }

    private static void dfs (int start) {

        visited[start] = true;

        for (int next : computers.get(start)) {
            if (!visited[next]) {
                virus++;
                dfs(next);
            }
        }

    }
}
