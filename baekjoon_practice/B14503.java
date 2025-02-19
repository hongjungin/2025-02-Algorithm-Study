import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B14503 {
    // 청소 x -> 현재 칸을 청소함
    // 4칸 중 빈칸이 없으면 -> 바라보는 방향 유지하고 후진 or 멈춤
    // 4칸 중 빈칸이 있으면 -> 반시계 방향으로 90도 회전 -> 앞이 청소 x면 한칸 전진
    // 0 : 청소 안됨 1 : 벽
    // bfs 이용해보자

    // 반시계 : 북 -> 서 -> 남 -> 동 (0 -> 3 -> 2 -> 1 -> 0 ..)
    static int N, M, r, c;
    static int[][] room;
    static int d; // 0 : 북 1 : 동 2 : 남 3 : 서
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        room = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //System.out.println(bfs(r,c,d));
    }

//    private static int bfs(int x, int y, int d) {
//        queue.add(new int[] {x, y, d});
//        room[x][y] = 2;
//        int cleanCount = 1;
//
//        while(!queue.isEmpty()) {
//            int[] node = queue.poll(); // 현재 위치 꺼내기
//            int cx = node[0];
//            int cy = node[1];
//            int direction = node[2];
//            boolean cleaned = false;
//
//            for (int i = 0; i < 4; i++) {
//                direction = (direction + 3) % 4;
//                int nx = cx + dx[i];
//                int ny = cy + dy[i];
//
//                // 청소해야할 곳이 있다면..
//                if (nx >= 0 && nx < N && ny >= 0 && ny < M && room[nx][ny] == 0) {
//                    queue.add(new int[] {nx, ny, direction});
//                    room[nx][ny] = 2;
//                    cleanCount++;
//                    cleaned = true;
//                    break;
//                }
//            }
//            // 4칸 다 청소됨 -> 후진
//            if (!cleaned) {
//                direction = (direction + 2) % 4;
//                int bx = cx + dx[direction];
//                int by = cy + dy[direction];
//
//                if (bx >= 0 && bx < N && by >= 0 && by < M && room[bx][by] != 1){
//                    queue.add(new int[] {bx, by, direction});
//                } else break;
//            }
//        }
//        return cleanCount;
//    }
}