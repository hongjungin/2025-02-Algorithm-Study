// 0 : 빈칸 9 : 상어위치


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B16236 {
    static int N;
    static int[][] sea;
    static int sharkSize;
    static int sx, sy;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        sea = new int[N][N];
        sx = 0;
        sy = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                sea[i][j] = Integer.parseInt(st.nextToken());
                if (sea[i][j] == 9) {
                    sx = i;
                    sy = j;
                }
            }
        }
        sharkSize = 2;
        getFish(sx, sy);

    }

    private static void getFish(int x, int y) {
        PriorityQueue<int[]> fish = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] != o2[0]) return Integer.compare(o1[0], o2[0]);
            if (o1[1] != o2[1]) return Integer.compare(o1[1], o2[1]);
            return Integer.compare(o1[2], o2[2]);
        });
        Queue<int[]> queue = new ArrayDeque<>();
//        pq.offer(new int[]{0, x, y});
//
//        while (!pq.isEmpty()) {
//            int[] node = pq.poll();
//            int before = node[0];
//            int cx = node[1];
//            int cy = node[2];
//
//            for (int i = 0; i < 4; i++) {
//                int nx = cx + dx[i];
//                int ny = cy + dy[i];
//
//                if (nx >= 0 && nx < N && ny >= 0 && ny < N && sea[nx][ny] <= sharkSize) {
//
//                }
//            }
//        }
    }
}
