import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 상하좌우로 지훈 , 불 각각 탐색 -> 불이 먼저 퍼지고, 지훈이가 갈 곳을 보는게 좋을 거 같은데....
// 미로의 가장자리에 접한 공간에서 탈출 -> 털출할 수 있는 기준 ?.....
// 지훈이와 불은 벽이 있는 공간 통과 못함.
// # 벽 . 공간 -> 벽 1 갈 수있는 곳 0
// F 불 J 지훈 -> 불 4 지훈 7
// J가 불이 도달하기 전에 미로 탈출 x면  IMPOSSIBLE 을 출력
public class Main {
    static int R, C;
    static int time;
    static int jx, jy;         // 지훈은 무조건 1개만 입력 받음
    static Queue<int[]> fire;  // 불은 여러개일 수 있음
    static Queue<int[]> jihoon;
    static int[][] fireMap;
    static int[][] maze;
    static boolean[][] visited;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        maze = new int[R][C];
        fireMap = new int[R][C];
        fire = new ArrayDeque<>();
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            Arrays.fill(fireMap[i], -1);
        }

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                char input = line.charAt(j);
                if (input == '#') {
                    maze[i][j] = 1;
                } else if (input == '.') {
                    maze[i][j] = 0;
                } else if (input == 'J') {
                    maze[i][j] = 7;
                    jx = i;
                    jy = j;

                } else if (input == 'F') {
                    maze[i][j] = 4;
                    fireMap[i][j] = 0;     // 0분 부터 시작
                    fire.offer(new int[] {i, j, 0});
                }

            }
        }
//		for (int i = 0; i < R; i++) {
//			for (int j = 0; j < C; j++) {
//				System.out.print(fireMap[i][j] + " ");
//			}
//			System.out.println();
//		}
//
        bfsFire();
        // 시작위치가 가장자리면 바로 탈출함
        if (jx == 0 || jx == R - 1 || jy == 0 || jy == C - 1) {
            System.out.println(1);
            return;
        }
        int result = bfsJihoon(jx, jy);
        if (result == -1) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(result);
        }
    }
    // 불은 visited 필요 없음 -> 4만 넣어주고
    // 분마다 현재 불 위치를 리스트에 저장해.
    private static void bfsFire() {

        while(!fire.isEmpty()) {
            int[] node = fire.poll();
            int cx = node[0];
            int cy = node[1];
            int fireTime = node[2];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                    if (maze[nx][ny] == 1) continue;

                    if (fireMap[nx][ny] == -1) {
                        fireMap[nx][ny] = fireTime + 1;
                        fire.offer(new int[]{nx, ny, fireTime + 1});
                    }
                }
            }
        }

    }
    private static int bfsJihoon(int x, int y) {
        jihoon = new ArrayDeque<>();
        jihoon.offer(new int[] {x, y, 0});
        visited[x][y] = true;


        while (!jihoon.isEmpty()) {
            int[] jNode = jihoon.poll();
            int jCx = jNode[0];
            int jCy = jNode[1];
            int time = jNode[2];

            for (int i = 0; i < 4; i++) {
                int jNx = jCx + dx[i];
                int jNy = jCy + dy[i];
                int nTime = time + 1;

                // 탈출한 경우
                if (jNx < 0 || jNx >= R || jNy < 0 || jNy >= C) {
                    return nTime;
                }

                if (maze[jNx][jNy] == 1 || visited[jNx][jNy]) continue;

                // 탈출 못하는 조건 + 불에 탐
                if (fireMap[jNx][jNy] != -1 && nTime >= fireMap[jNx][jNy]) {
                    continue;
                }

                jihoon.offer(new int[] {jNx, jNy, nTime});
                visited[jNx][jNy] = true;
            }
        }
        return -1;
    }

}
