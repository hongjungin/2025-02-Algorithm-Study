// 방은 N x M -> 벽 또는 빈칸
// 청소기 방향 -> 동서남북
// 처음에 빈칸은 전부 청소되지 않음

// 현재 칸 청소 x -> 청소해
// 현재 칸 주변 4칸 중 전부 청소됨 -> 바라보는 방향 유지하고 한칸 후진
// 후진했는데 벽이면 작동을 멈춰.

// 주변 4칸 중 청소 x 있어 -> 반시계 방향으로 90도 회전
// 회전한 방향 기준으로 전진이 청소 x면 전진

// 0 북 1 동 2 남 3 서
// 입력 : N M -> 청소기 시작 칸 / 방향
// 0 청소 안됨 1 벽

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B14503 {
    static int N, M;
    static int direction;
    static int startX, startY;
    static  int cleanCount;
    static int[][] room;
    static StringTokenizer st;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        startX = Integer.parseInt(st.nextToken());
        startY = Integer.parseInt(st.nextToken());
        direction = Integer.parseInt(st.nextToken());

        room = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cleanCount = 0;
        clean(startX, startY, direction);

        System.out.println(cleanCount);
    }

    private static void clean(int x, int y, int d) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y, d});
        room[x][y] = 2;      // 청소 o
        cleanCount++;

        while (!queue.isEmpty()) {
            boolean isCleaned = false;
            int[] node = queue.poll();
            int cx = node[0];
            int cy = node[1];
            int dir = node[2];

            for (int i = 0; i < 4; i++) {
                dir = (dir + 3) % 4;
                int nx = cx + dx[dir];
                int ny = cy + dy[dir];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    // 방문도 안했고 청소도 안하면 이동
                    if (room[nx][ny] == 0) {
                        queue.offer(new int[]{nx, ny, dir});
                        room[nx][ny] = 2;
                        isCleaned = true;
                        cleanCount++;
                        break;
                    }
                }
            }
            // 전부 청소했어 -> 후진 해야함
            if (!isCleaned) {
                int backDir = (dir + 2) % 4;
                int bx = cx + dx[backDir];
                int by = cy + dy[backDir];

                if (bx >= 0 && bx < N && by >= 0 && by < M) {
                    if (room[bx][by] != 1) {
                        queue.offer(new int[]{bx, by, dir});
                    } else {
                        return;
                    }
                }
            }
        }

    }
}