import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int R, C, K;
    static char arr[][];
    static boolean visited[][];
    static int count = 0;
    
    // 이동 방향 (상, 하, 좌, 우)
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);

        arr = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            arr[i] = br.readLine().toCharArray(); // C만큼 들어감
        }

        // 출발 (왼쪽 아래: [R-1, 0])
        visited[R - 1][0] = true;
        perm(R - 1, 0, 1);
        System.out.println(count);
    }

    private static void perm(int r, int c, int depth) {
        // 도착 (오른쪽 위: (0, C-1))
        if (r == 0 && c == C - 1) {
            if (depth == K) count++;
            return ;
        }

        // 4방 탐색
        for (int i = 0; i < 4; i++) {
            int mr = r + dr[i];
            int mc = c + dc[i];

            // 범위 체크 및 방문 가능 여부 확인
            if (mr >= 0 && mr < R && mc >= 0 && mc < C && !visited[mr][mc] && arr[mr][mc] != 'T') {
                visited[mr][mc] = true;
                perm(mr, mc, depth + 1);
                visited[mr][mc] = false;
            }
        }
    }
}
