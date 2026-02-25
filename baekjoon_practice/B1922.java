import java.io.*;
import java.util.*;

public class B1922 {

    static int N, M;

    static class Edge {
        int a, b;
        int w;
        Edge(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }
    }

    // Union-Find용
    static int[] parent;
    static int[] rank;

    // x 가 속한 그룹의 루트를 리턴할 함수
    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    // true면 서로 다른 그룹을 합친 것
    // false면 안 합친것 -> 이미 같은 그룹이거나 이걸 넣으면 사이클 생김
    static boolean union(int a, int b) {
        int ra = find(a);
        int rb = find(b);

        if(ra == rb) return false; // 이미 같은 그룹이면 합칠 필요x

        if (rank[ra] < rank[rb]) {
            rank[rb] += rank[ra];
            parent[ra] = rb;
        } else {
            rank[ra] += rank[rb];
            parent[rb] = ra;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        List<Edge> edges = new ArrayList<>(M);

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edges.add(new Edge(a, b, w));
        }

        Collections.sort(edges, Comparator.comparingInt(e -> e.w));

        long answer = 0;
        int cnt = 0;

        for (Edge e : edges) {
            if (e.a == e.b) continue;

            if (union(e.a, e.b)) {
                answer += e.w;
                cnt++;
                if (cnt == N-1) break;
            }
        }

        System.out.println(answer);
    }
}
