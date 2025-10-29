import java.util.*;
import java.io.*;

// 1: 이동 가능 0: 이동 불가
// (1,1)에서 출발 (N,M) 도착 -> 지나는 최소 칸의 수
//

public class Main {
    static int N, M, count;
    static char[][] board;
    static int startX, startY;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main (String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for(int i = 1; i < N + 1; i++) {
            String line = br.readLine();
            for (int j = 1; j < M + 1; j++) {
                board[i][j] = line.charAt(j-1);
            }
        }

        startX = 1;
        startY = 1;
        bfs();

        System.out.println(count);
    }

    private static void bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startX, startY, 1});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            int dist = cur[2];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx == N && ny == M) {
                    dist += 1;
                    count = dist;
                    return;
                }

                if (nx > 0 && ny > 0 && nx <= N && ny <= M && board[nx][ny] == '1' && !visited[nx][ny]) {
                    queue.offer(new int[]{nx, ny, dist + 1});
                    visited[nx][ny] = true;
                }
            }
        }


    }
}
