import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 꽃이 겹치면 안됨 -> 최소비용
// 꽃 씨앗 3개

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(min);
    }

    static void dfs(int depth, int sum) {
        if (depth == 3) {
            min = Math.min(min, sum);
            return;
        }

        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                if (canPlace(i, j)) {
                    int cost = place(i, j, true);
                    dfs(depth + 1, sum + cost);
                    place(i, j, false);
                }
            }
        }
    }

    static boolean canPlace(int x, int y) {
        if (visited[x][y]) return false;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (visited[nx][ny]) return false;
        }
        return true;
    }

    static int place(int x, int y, boolean plant) {
        int cost = map[x][y];
        visited[x][y] = plant;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            visited[nx][ny] = plant;
            cost += map[nx][ny];
        }

        return cost;
    }
}
