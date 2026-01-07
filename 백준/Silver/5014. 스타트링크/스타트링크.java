import java.io.*;
import java.util.*;

// 총 F층, 스타트링크 위치는 G층
// 강호는 S층 -> G층에 엘베로 가야 함
// 엘베는 위로 U층 아래로 D층 이동
// 위 아래 층이 없으면 움직이지 않음
// G층에 가려면 버튼을 적어도 몇 번 눌러야 하는지 출력
// 갈 수 X -> "use the stairs"

// 1 <= S , G <= F <= 1,000,000
// 0 <= U,D <= 1,000,000

// 입력 : F S G U D 순 10 1 10 2 1 / result:6

public class Main {

    static int F, S, G, U, D;
    static boolean[] visited;

    public static void main (String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        visited = new boolean[F + 1];

        System.out.println(bfs(S));
    }

    static String bfs(int start) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{start, 0});
        visited[start] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int c = cur[0];
            int dist = cur[1];

            if (c == G) {
                return String.valueOf(dist);
            }

            int n1 = c + U;
            int n2 = c - D;

            if (n1 > 0 && n1 <= F && !visited[n1]) {
                queue.add(new int[]{n1, dist + 1});
                visited[n1] = true;
            } 
            if (n2 > 0 && n2 <= F && !visited[n2]) {
                queue.add(new int[]{n2, dist + 1});
                visited[n2] = true;
            }
        }
        return "use the stairs";
    }
}
