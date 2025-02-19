import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B2667 {
    // 1: 집이 있는 곳 2: 집이 없는 곳
    // 상하좌우 연결 = 단지 -> bfs로 탐색
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int dist;
    static int count;
    static List<Integer> danzi = new ArrayList<>();

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    danzi.add(bfs(i, j));
                    count++;
                    Collections.sort(danzi);
                }
            }
        }
        System.out.println(count);
        for (int num : danzi) {
            System.out.println(num);
        }

    }
    private static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;
        dist = 1;

        while(!queue.isEmpty()) {
            int[] node = queue.poll(); // 현재 위치 꺼내기
            int cx = node[0];
            int cy = node[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && map[nx][ny] == 1) {
                    queue.add(new int[] {nx, ny});
                    visited[nx][ny] = true;
                    dist++;
                }
            }
        }
        return dist;
    }
}
