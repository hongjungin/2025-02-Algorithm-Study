import java.io.*;
import java.util.*;

// 1:벽 0:갈 수 있음

public class Main_2206 {
    static int N, M;
    static int[][] map;
    static boolean[][][] visited;
    static class Point {
        int r, c, dist;
        int broken;

        Point(int r, int c, int dist, int broken) {
            this.r = r;
            this.c = c;
            this.dist = dist;
            this.broken = broken;
        }
    }
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                int input = line.charAt(j) - '0';
                map[i][j] = input;
            }
        }

        visited = new boolean[N][M][2];

        System.out.println(bfs(0,0));

    }

    private static int bfs(int r, int c) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(r, c, 1, 0));
        visited[r][c][0] = true;

        while(!queue.isEmpty()) {
            Point p = queue.poll();

            if (p.r == N - 1 && p.c == M - 1) {
                return p.dist;
            }

            for (int i = 0; i < 4; i++) {
                int nr = p.r + dx[i];
                int nc = p.c + dy[i];

                if (nr >= 0 && nr < N && nc >= 0 && nc > M) {
                    // 다음 칸이 길이야
                    if (map[nr][nc] == 0) {
                        if (!visited[nr][nc][p.broken]) {
                            visited[nr][nc][p.broken] = true;
                            queue.add(new Point(nr, nc, p.dist + 1, p.broken));
                        }

                    } else if (map[nr][nc] == 1) { // 다음 칸이 벽임
                        if (p.broken == 0 && !visited[nr][nc][1]) {
                            visited[nr][nc][1] = true;
                            queue.add(new Point(nr, nc, p.dist + 1, 1));
                        }
                    }
                }
            }
        }
        return -1;
    }
}
