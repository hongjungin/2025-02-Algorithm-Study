import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 처음 상어 크기 2
// 먹을게 많으면 가장 가까운 물고기
// 가까운 물고기 많으면 가장 왼쪽 위
public class Main {
    static int N, sharkSize, s, time;
    static int[][] sea;
    static int[][] dist;
    static boolean[][] visited;
    static Queue<int[]> shark;
    static Queue<int[]> sharkDist;
    static PriorityQueue<int[]> fishesToEat;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        sea = new int[N][N];
        shark = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                sea[i][j] = Integer.parseInt(st.nextToken());
                if (sea[i][j] == 9) {
                    shark.offer(new int[] {i, j});
                }
            }
        }

        sharkSize = 2;
        s = 0;
        time = 0;
        startBfs();
        System.out.println(time);
    }
    private static void startBfs() {
        while(!shark.isEmpty()) {
            int[] current = shark.poll();
            int cx = current[0];
            int cy = current[1];
            sea[cx][cy] = 0;
            setDist(cx, cy);

            if (!fishesToEat.isEmpty()){
                int[] fish = fishesToEat.poll();
                int fx = fish[0];
                int fy = fish[1];
                shark.offer(fish);
                s++;
                if(s == sharkSize) {
                    sharkSize++;
                    s = 0;
                }

                sea[fx][fy] = 0;

                time += dist[fx][fy];
            }
        }

    }
    // 상어의 현재 위치부터의 거리 구하기
    private static void setDist(int x, int y) {
        dist = new int[N][N];
        visited = new boolean[N][N];
        sharkDist = new ArrayDeque<>();
        sharkDist.offer(new int[] {x, y, 0});
        visited[x][y] = true;
        fishesToEat = new PriorityQueue<>((a, b) -> {
            if (a[2] != b[2]) return Integer.compare(a[2], b[2]);
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        while(!sharkDist.isEmpty()) {
            int[] cur = sharkDist.poll();
            int cx = cur[0];
            int cy = cur[1];
            int d = cur[2];

            if (sea[cx][cy] != 0 && sea[cx][cy] < sharkSize) {
                fishesToEat.offer(new int[]{cx, cy, d});
            }

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && sea[nx][ny] <= sharkSize) {
                    sharkDist.offer(new int[] {nx, ny, d + 1});
                    visited[nx][ny] = true;
                    dist[nx][ny] = d + 1;
                }
            }
        }
    }
}
