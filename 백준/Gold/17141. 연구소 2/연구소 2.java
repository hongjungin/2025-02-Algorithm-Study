import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 0 : 빈 칸, 1 : 벽, 2 : 바이러스 -> 여기 중 M개 선택
public class Main {
    static int N, M;
    static int[][] lab;
    static List<int[]> virus;
    static List<int[]> selectVirus;
    static boolean[][] visited;
    static int time;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lab = new int[N][N];
        virus = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                if (lab[i][j] == 2) {
                    virus.add(new int[]{i, j});
                }
            }
        }
        time = Integer.MAX_VALUE;
        selectVirus = new ArrayList<>();
        combiVirus(0, 0);
        if (time == Integer.MAX_VALUE) {
            time = -1;
        }
        System.out.println(time);
    }

    private static void combiVirus(int depth, int start) {
        if (depth == M) {
            time = Math.min(time, spread());
            return;
        }
        for (int i = start; i < virus.size(); i++) {
            selectVirus.add(new int[]{virus.get(i)[0], virus.get(i)[1], 0});
            combiVirus(depth + 1, i + 1);
            selectVirus.remove(selectVirus.size() - 1);
        }
    }

    private static int spread() {
        Queue<int[]> queue = new ArrayDeque<>();
        visited = new boolean[N][N];
        for (int i = 0; i < selectVirus.size(); i++) {
            queue.offer(new int[]{selectVirus.get(i)[0], selectVirus.get(i)[1], 0});
            visited[selectVirus.get(i)[0]][selectVirus.get(i)[1]] = true;
        }

        int maxDist = 0;

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int cx = node[0];
            int cy = node[1];
            int dist = node[2];
            maxDist = Math.max(maxDist, dist);

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && lab[nx][ny] != 1) {
                    queue.offer(new int[]{nx, ny, dist + 1});
                    visited[nx][ny] = true;
                }
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (lab[i][j] != 1 && !visited[i][j]) {
                    return Integer.MAX_VALUE;
                }
            }
        }
        return maxDist;
    }
}
