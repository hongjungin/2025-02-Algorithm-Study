import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, count;
    static boolean[][][] visited;
    static int[] dx = {9, 9, 3, 3, 1, 1};
    static int[] dy = {3, 1, 9, 1, 3, 9};
    static int[] dz = {1, 3, 1, 9, 9, 3};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] scv = new int[3];
        for (int i = 0; i < N; i++) {
            scv[i] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[61][61][61];
        count = 0;
        destroy(scv[0], scv[1], scv[2]);
        System.out.println(count);
    }

    private static void destroy(int x, int y, int z) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y, z, 0});
        visited[x][y][z] = true;

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int cx = node[0];
            int cy = node[1];
            int cz = node[2];
            int turn = node[3];

            if (cx == 0 && cy == 0 && cz == 0) {
                count = turn;
                return;
            }

            for (int i = 0; i < 6; i++) {
                int nx = Math.max(0, cx - dx[i]);
                int ny = Math.max(0, cy - dy[i]);
                int nz = Math.max(0, cz - dz[i]);

                if (nx >= 0 && ny >= 0 && nz >= 0) {

                    if (!visited[nx][ny][nz]) {
                        visited[nx][ny][nz] = true;
                        queue.offer(new int[]{nx, ny, nz, turn + 1});
                    }
                }
            }
        }

    }
}
