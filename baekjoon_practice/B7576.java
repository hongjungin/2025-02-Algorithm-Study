import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class B7576 {
    // 최소 / 노드 탐색 -> bfs로 풀어
    // 1 : 익은 토마토 0 : 익지 않은 토마토 -1 : 토마토 없음
    // 저장될 때부터 모든 토마토 익어있어 -> 0 출력
    // 토마토 모두가 익지는 못하면 -> -1 출력
    static int N, M;
    static int[][] box;
    static Queue<int[]> queue = new LinkedList<>();
    static int countZero;
    static int maxDay;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // M은 가로(열) N은 세로(행)
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        // 배열에 값 입력
        box = new int[N][M];
        countZero = 0;
        maxDay = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j] == 1) {
                    // 여러 개의 시적점을 큐에 넣음
                    queue.add(new int[]{i, j});
                }
                if(box[i][j] == 0) {
                    countZero++;
                }
            }
        }
        if (countZero == 0) {
            System.out.println(0);
            return;
        }
        bfs();

        // 출력
        if (countZero > 0) { // 익지 않은 토마토가 남아 있다면
            System.out.println(-1);
        } else {
            System.out.println(maxDay - 1);
        }
    }

    private static void bfs() {
        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            int cx = node[0];
            int cy = node[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];


                if (nx >= 0 && nx < N && ny >= 0 && ny < M && box[nx][ny] == 0) {
                    queue.add(new int[]{nx, ny});
                    box[nx][ny] = box[cx][cy] + 1;
                    maxDay = Math.max(maxDay, box[nx][ny]);
                    countZero--;

                    if (countZero == 0) return;
                }
            }
        }
    }
}
