import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][][] visited;
    static int[][][] parentX, parentY, parentWall;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Point {
        int x, y, dist;
        boolean broke;

        public Point(int x, int y, int dist, boolean broke) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.broke = broke;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2];
        parentX = new int[N][M][2];
        parentY = new int[N][M][2];
        parentWall = new int[N][M][2];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        int result = bfs();
        System.out.println(result);

        // 경로 역추적 (최단 경로가 존재할 경우)
        if (result != -1) {
            tracePath();
        }
    }

    static int bfs() {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0, 1, false));
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Point cur = q.poll();

            if (cur.x == N - 1 && cur.y == M - 1) return cur.dist;

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                // 벽이 아닌 경우
                if (map[nx][ny] == 0) {
                    if (!visited[nx][ny][cur.broke ? 1 : 0]) {
                        visited[nx][ny][cur.broke ? 1 : 0] = true;
                        q.offer(new Point(nx, ny, cur.dist + 1, cur.broke));
                        parentX[nx][ny][cur.broke ? 1 : 0] = cur.x;
                        parentY[nx][ny][cur.broke ? 1 : 0] = cur.y;
                        parentWall[nx][ny][cur.broke ? 1 : 0] = cur.broke ? 1 : 0;
                    }
                }
                // 벽을 처음 부수는 경우
                else if (map[nx][ny] == 1 && !cur.broke) {
                    if (!visited[nx][ny][1]) {
                        visited[nx][ny][1] = true;
                        q.offer(new Point(nx, ny, cur.dist + 1, true));
                        parentX[nx][ny][1] = cur.x;
                        parentY[nx][ny][1] = cur.y;
                        parentWall[nx][ny][1] = 0; // 이전에는 부수지 않았음
                    }
                }
            }
        }
        return -1;
    }

    static void tracePath() {
        // 도착지 상태부터 시작
        int cx = N - 1;
        int cy = M - 1;
        int wall = visited[cx][cy][0] ? 0 : 1;

        List<String> path = new ArrayList<>();
        while (!(cx == 0 && cy == 0)) {
            path.add("(" + cx + "," + cy + ")");
            int px = parentX[cx][cy][wall];
            int py = parentY[cx][cy][wall];
            int pw = parentWall[cx][cy][wall];

            cx = px;
            cy = py;
            wall = pw;
        }
        path.add("(0,0)");
        Collections.reverse(path);
        //System.out.println("경로: " + path);
    }
}
