import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][][] visited;
    static int[][][] parentX, parentY, parentWall;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Point {
        int x, y, dist, broke;

        public Point(int x, int y, int dist, int broke) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.broke = broke;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2];
        parentX = new int[N][M][2];
        parentY = new int[N][M][2];
        parentWall = new int[N][M][2];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int result = bfs();
        System.out.println(result);
    }

    static int bfs() {
        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(0, 0, 1, 0));
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Point cur = q.poll();

            if (cur.x == N - 1 && cur.y == M - 1) {
                int wallStatus = cur.broke;
                int curX = cur.x;
                int curY = cur.y;
                List<String> path = new ArrayList<>();

                while (!(curX == 0 && curY == 0)) {
                    int prevX = parentX[curX][curY][wallStatus];
                    int prevY = parentY[curX][curY][wallStatus];
                    int prevWallStatus = parentWall[curX][curY][wallStatus];

                    curX = prevX;
                    curY = prevY;
                    wallStatus = prevWallStatus;
                }

                Collections.reverse(path);
                return cur.dist;
            }

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                
                if (map[nx][ny] == 0 && !visited[nx][ny][cur.broke]) {
                    visited[nx][ny][cur.broke] = true;
                    q.offer(new Point(nx, ny, cur.dist + 1, cur.broke));
                    parentX[nx][ny][cur.broke] = cur.x;
                    parentY[nx][ny][cur.broke] = cur.y;
                    parentWall[nx][ny][cur.broke] = cur.broke;
                }

                if (map[nx][ny] == 1 && cur.broke == 0 && !visited[nx][ny][1]) {
                    visited[nx][ny][1] = true;
                    q.offer(new Point(nx, ny, cur.dist + 1, 1));
                    parentX[nx][ny][1] = cur.x;
                    parentY[nx][ny][1] = cur.y;
                    parentWall[nx][ny][1] = cur.broke;
                }
            }
        }
        return -1;
    }
}
