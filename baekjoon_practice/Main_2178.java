import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// N 가로 M 세로
// 1 이동 가능 0 이동 x
// 1,1 에서 N,M 으로 최소의 칸을 이동
// 보통 최소면 bfs지 않나?

public class Main_2178 {
    static char[][] map;
    static int N, M;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N+1][M+1];

        for (int i = 1; i < N+1; i++) {
            String line = br.readLine();
            for (int j = 1; j < M+1; j++) {
                map[i][j] = line.charAt(j-1);
            }
        }

        visited = new boolean[N+1][M+1];
        System.out.println(bfs(1,1, 1));
    }
    static int bfs(int x,  int y, int dist) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x,y,1});
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            int cx = node[0];
            int cy = node[1];
            int d = node[2];

            if(cx == N && cy == M) {
                return d;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx <= 0 || ny <= 0 || nx > N || ny > M) {
                    continue;
                } else {
                    if (!visited[nx][ny] && map[nx][ny] == '1') {
                        queue.offer(new int[]{nx, ny, d + 1});
                        visited[nx][ny] = true;
                    }
                }

            }
        }
        return -1;
    }
}
