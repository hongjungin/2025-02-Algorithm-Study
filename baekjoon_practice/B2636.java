import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 0 : 공기 1 : 치즈
//
public class B2636 {
    static int N, M;
    static int[][] board;
    static boolean[][] visited;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 이건 시작점이 명확이 없으니까 이중 for문으로 bfs 돌리는게 맞을 거 같아
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 1 && !visited[i][j]){
                    bfs(i, j);
                }
            }
        }
    }

    private static void bfs(int x, int y) {
        // 1인데 주변에 0이 없는 치즈 , 1밖에 없는 치즈 이렇게 큐 나눔
        Queue<int[]> meltingChesse = new ArrayDeque<>();
        Queue<int[]> nextChesse = new ArrayDeque<>();

        meltingChesse.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!meltingChesse.isEmpty()) {
            int size = meltingChesse.size();
            for (int i = 0; i < size; i++) {
                int[] node = meltingChesse.poll();
                int cx = node[0];
                int cy = node[1];

                for (int j = 0; j < 4; j++) {
                    int nx = cx + dx[i];
                    int ny = cy + dy[i];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < 0 && !visited[nx][ny]) {
                        if (board[nx][ny] == 0) {
                            nextChesse.offer(new int[]{nx, ny});
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
        }
    }
}