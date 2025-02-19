import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 0 : 공기 1 : 치즈
    // 외부 공기 탐색 -> bfs? dfs? -> bfs 사용하자
    //
    static int N, M;
    static int[][] board;
    static boolean[][] visited;
    static Queue<int[]> queue = new LinkedList<>();

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 입력 받기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int time = 0;
        int lastCheese = 0;
        while(true) {
            visited = new boolean[N][M];
            bfs();
            List<int[]> cheese = findCheese();
            if(cheese.isEmpty()) break;
            lastCheese = cheese.size();
            meltCheese(cheese);
            time++;
        }
        System.out.println(time);
        //System.out.println(lastCheese);
    }
    // 녹을 치즈 -> 0
    private static void meltCheese(List<int[]> cheese) {
        for (int[] c : cheese) {
            board[c[0]][c[1]] = 0;
        }
    }

    // 치즈가 공기랑 접하는 변 2개 이상 -> 녹을 치즈
    private static List<int[]> findCheese() {
        List<int[]> cheese = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 1){
                    int air = 0;

                    for (int k = 0; k < 4; k++){
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx >= 0 && ny >= 0 && nx < N && ny < M && visited[nx][ny]) {
                            air++;
                        }
                    }
                    if (air >= 2) {
                        cheese.add(new int[]{i, j});
                    }
                }
            }
        }

        return cheese;
    }

    private static void bfs() {
        queue.clear();
        queue.add(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int cx = node[0];
            int cy = node[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] && board[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }

}