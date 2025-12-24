import java.util.*;
import java.io.*;

// 상하좌우 이동 가능
// 필요한 최소 지렁이 개수
// 0은 배추 x, 1은 배추 o

public class Main {

    static int T, M, N, K, X, Y;
    static int[][] field;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            field = new int[M][N];
            visited = new boolean[M][N];

            for (int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine());

                int m = Integer.parseInt(st.nextToken());
                int n = Integer.parseInt(st.nextToken());

                field[m][n] = 1;
            }

            int count = 0;

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && field[i][j] == 1) {
                        bfs(i, j);
                        count++;
                    }
                }
            }

            sb.append(count).append("\n");
        }
        
        System.out.println(sb);
    }

    private static void bfs(int m, int n) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {m, n});
        visited[m][n] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < M && ny >= 0 && ny < N && !visited[nx][ny] && field[nx][ny] == 1) {
                    queue.add(new int[] {nx, ny});
                    visited[nx][ny]= true;
                }
            }
        }

    }

}
