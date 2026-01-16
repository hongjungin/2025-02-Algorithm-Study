import java.io.*;
import java.util.*;

// 루트가 있는 트리
// 가장 가까운 공룡 조상 -> 두 노드를 모두 자손으로 같음 + 가장 깊이가 깊은
// 노드 수 N (2 <= N <= 10,000)
// A B 순 -> A가 B의 부모

// 이 문제 유형은 LCA(Least Common Ancestor)임

public class Main {

    static int T, N;
    static int n1, n2, a;
    static int[] parent;
    static boolean[] visited;
    static StringTokenizer st;

    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());

            parent = new int[N + 1];
            visited = new boolean[N + 1];

            for (int i = 0; i < N - 1; i++) {
                st = new StringTokenizer(br.readLine());

                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());

                parent[B] = A;
            }

            st = new StringTokenizer(br.readLine());

            n1 = Integer.parseInt(st.nextToken());
            n2 = Integer.parseInt(st.nextToken());

            int cur = n1;

            while(cur != 0) {
                visited[cur] = true;
                cur = parent[cur];
            }

            cur = n2;
            while(cur != 0) {
                if (visited[cur]) {
                    sb.append(cur).append("\n");
                    break;
                }
                cur = parent[cur];
            }
        }

        System.out.println(sb);
    }
}
