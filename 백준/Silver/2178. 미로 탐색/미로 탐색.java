import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 문제 보고 왜 BFS를 사용해야 하는가?
// (0,0) -> (N-1, M-1)까지 가는 최단 경로 구해야 함.
// 최단 거리 문제는 대부분 BFS 로 해결 가능

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static int[][] minDist;
    static boolean[][] visited;
    static int[] dr = {-1, 0 , 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력 받기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        minDist = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
                minDist[i][j] = Integer.MAX_VALUE;
            }
        }
        bfs(0,0);
        System.out.println(minDist[N-1][M-1]);
    }

    static void bfs(int x, int y) {
        // 큐로 현재 위치랑 이동 거리 저장
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y, 1});
        visited[x][y] = true;
        minDist[x][y] = 1;

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            // 현재 행 위치
            int cx = node[0];
            // 현재 열 위치
            int cy = node[1];
            // 현재까지 이동한 거리
            int dist = node[2];

            if (cx == N - 1 && cy == M - 1) {
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cx + dr[i];
                int ny = cy + dc[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && map[nx][ny] == 1) {
                    queue.add(new int[]{nx, ny, dist + 1});
                    visited[nx][ny] = true;
                    // 다음 위치 최단 거리
                    minDist[nx][ny] = dist + 1;
                }
            }
        }
    }
}