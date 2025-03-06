// 연구소 크기 N x M
// 바이러스 확산 막기 위해 벽 세움
// 연구소는 빈칸 or 벽
// 새로 세울 수 있는 벽은 3개 -> 꼭 3개 전부 세움

// 0 빈 칸 1 벽 2 바이러스
// 빈 칸의 개수는 3개 이상
// 바이러스에서 bfs 탐색 -> visited 굳이 필요 없을 거 같은데
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, R;
    static int safeZone;
    static int[][] lab;
    static int[][] labCopy;
    static List<int[]> virus;
    static List<int[]> wall;
    static List<int[]> empty;
    static int[] dx = {-1, 0 , 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = 3;
        lab = new int[N][M];
        virus = new ArrayList<>();
        empty = new ArrayList<>();
        wall = new ArrayList<>();
        // 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                if (lab[i][j] == 2) {
                    virus.add(new int[]{i, j});
                } else if (lab[i][j] == 0) {
                    empty.add(new int[]{i, j});
                }
            }
        }

        combi(0, 0);
        System.out.println(safeZone);
    }

    static void combi(int depth, int start) {
        // 기저 조건
        if (depth == R) {
            // 깊은 복사
            labCopy = new int[N][];
            for (int i = 0; i < N; i++) {
                labCopy[i] = lab[i].clone();
            }

            for (int i = 0; i < R; i++) {
                int[] pos = wall.get(i);
                labCopy[pos[0]][pos[1]] = 1;   // 벽 세움
            }

            safeZone = Math.max(safeZone, bfs());
            return;
        }
        for (int i = start; i < empty.size(); i++) {
            wall.add(empty.get(i));
            combi(depth + 1, i + 1);
            wall.remove(wall.size() - 1);
        }

    }

    static int bfs() {
        Queue<int[]> virusQueue = new ArrayDeque<>();

        for (int[] pos : virus) {
            virusQueue.offer(new int[]{pos[0], pos[1]});
        }

        while (!virusQueue.isEmpty()) {
            int[] node = virusQueue.poll();
            int cx = node[0];
            int cy = node[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (labCopy[nx][ny] == 0) {
                        labCopy[nx][ny] = 2;
                        virusQueue.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        safeZone = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (labCopy[i][j] == 0) {
                    safeZone++;
                }
            }
        }
        return safeZone;
    }
}
