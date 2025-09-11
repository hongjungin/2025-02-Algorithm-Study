import java.util.*;

class Main_3 {

    static int n, m, answer = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;

    public void DFS (int v) {
        if (v == n) answer++;
        else {
            for (int nv : graph.get(v)) {
                if (!visited[nv]) {
                    visited[nv] = true;
                    DFS(nv);
                    visited[nv] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Main_3 T = new Main_3();
        Scanner kb = new Scanner(System.in);

        n = kb.nextInt();
        m = kb.nextInt();

        graph = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            graph.get(a).add(b);
        }

        visited[1] = true;
        T.DFS(1);
        System.out.println(answer);

    }
}
