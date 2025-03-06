import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 한수 현재 위치 :  왼쪽 아래
// 집 위치 : 오른쪽 위
// 지나친 곳 방문 x
// T 는 가지 못하는 곳 : 1
// . 갈 수 있는 곳 : 0
// 집까지 가는 거리가 k인 가짓수
public class Main {
    static int R, C, K;
    static int startX, startY, finishX, finishY;
    static int count;
    static int[][] map;
    static List<int[]> select;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        startX = R - 1;
        startY = 0;
        finishX = 0;
        finishY = C - 1;

        map = new int[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                if (line.charAt(j) == '.') {
                    map[i][j] = 0;
                } else if (line.charAt(j) == 'T') {
                    map[i][j] = 1;
                }
            }
        }
        select = new ArrayList<>();
        count = 0;
        dfs(startX, startY, 1);
        System.out.println(count);
    }

    private static void dfs(int x, int y, int d) {
        select.add(new int[]{x, y});
        visited[x][y] = true;

        if (x == finishX && y == finishY){
            if (d == K) {
                count++;
            }
            visited[x][y] = false;
            select.remove(select.size() - 1);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[nx][ny] && map[nx][ny] == 0) {
                dfs(nx, ny, d + 1);
            }
        }
        visited[x][y] = false;
        select.remove(select.size() - 1);
    }
}
