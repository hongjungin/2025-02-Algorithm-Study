import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int max;
    static int arr[][];
    static int dr[] = {-1, -1, 0, 1, 1, 1, 0, -1}; // 8방 탐색 x축
    static int dc[] = {0, 1, 1, 1, 0, -1, -1, -1}; // 8방 탐색 y축

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        Queue<int[]> q = new LinkedList<>();

        // 배열 입력 및 아기 상어 위치를 큐에 삽입
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    q.add(new int[]{i, j});
                }
            }
        }
        
        // 가장 먼 안전 거리 저장
        max = 0;

        // BFS 실행
        while (!q.isEmpty()) {
            int cur[] = q.poll();
            int r = cur[0];
            int c = cur[1];

            for (int d = 0; d < 8; d++) {
                int mr = r + dr[d];
                int mc = c + dc[d];

                // 범위를 벗어난 경우
                if (mr < 0 || mr >= N || mc < 0 || mc >= M) continue;

                // 이미 방문했거나 상어가 있는 경우 스킵
                if (arr[mr][mc] != 0) continue;

                // 안전 거리 갱신 (이전 칸의 값 + 1)
                arr[mr][mc] = arr[r][c] + 1;
                max = Math.max(max, arr[mr][mc]); // 최대값 갱신
                q.add(new int[]{mr, mc});
            }
        }

        // 가장 큰 거리에서 -1 (초기값이 1이므로 조정)
        System.out.println(max - 1);
    }
}
