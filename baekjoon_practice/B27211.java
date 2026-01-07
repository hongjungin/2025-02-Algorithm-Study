import java.util.*;
import java.io.*;

// N x M -> 상하좌우 이동
// 집 위치 (0,0) -> M칸 이동하면 다시 (0,0)
// (0,0)에서 왼쪽으로 한칸 가면 (0, M-1)
// 이어진 구역의 갯수? -> 일단 문제는 bfs임
// 도넛 모양인게 관건 (양 끝 값 처리가 중요할 듯)
// 0 이면 비어있음 1이면 막힘

public class B27211 {

    static int N, M, count;
    static int[][] donut;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        donut = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                donut[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (donut[i][j] == 0 && !visited[i][j]) {
                    bfs(i, j);
                    count++;
                }

            }
        }

        System.out.println(count);

    }

    static void bfs (int startX, int startY) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx == N) {
                    nx = 0;
                } else if (ny == M) {
                    ny = 0;
                } else if (ny < 0) {
                    ny = M - 1;
                } else if (nx < 0) {
                    nx = N - 1;
                }

                if (!visited[nx][ny] && donut[nx][ny] == 0) {
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }

    }
}

// 예시 입력

//5 6
//1 1 1 1 1 1
//1 0 0 0 1 1
//1 1 1 1 0 0
//1 1 1 1 0 0
//1 1 1 1 1 1

//result : 2

//7 8
//0 0 1 1 0 0 0 0
//0 1 1 1 1 0 1 0
//1 1 1 1 1 1 1 1
//0 1 1 1 1 1 0 0
//1 1 0 0 0 1 0 0
//0 1 0 0 0 1 0 1
//0 0 1 1 1 1 0 0
//
//result : 2