import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2174_BFS {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;

    // 상 우 하 좌 방향
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        bfs(0,0);
    }
    private static int bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y, 1});
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            int[] node = queue.poll();   // 큐에서 현재 노드 꺼내기
            int cx = node[0];
            int cy = node[1];
            int dist = node[2];

            // 목적지 도착 확인 -> N-1, M-1 도착하면 거리 반환
            if(cx == N - 1 && cy == M - 1) {
               return dist;
            }

            // 네 방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i]; // 다음에 이동할 x좌표
                int ny = cy + dy[i]; // 다음에 이동할 y좌표

                // 이동 가능 여부 체크
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && map[nx][ny] == 1){
                    queue.add(new int[]{nx, ny, dist + 1}); // 이동할 좌표와 이동 거리 큐에 삽입
                    visited[nx][ny] = true;
                }
            }
        }
        return -1;   // 도달할 수 없는 경우
    }
}
