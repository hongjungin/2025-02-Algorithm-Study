import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
    static int T, R, C;
    static int time;
    static int jx, jy;
    static int[][] maze;
    static int[][] fireMap;
    static Queue<int[]> fire;
    static boolean[][] visited;
    static Queue<int[]> jihoon;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        
        
        for (int t = 0; t < T; t++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());

            C = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());

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
                    } else if (input == '@') {
                        maze[i][j] = 7;
                        jx = i;
                        jy = j;

                    } else if (input == '*') {
                        maze[i][j] = 4;
                        fireMap[i][j] = 0;     // 0분 부터 시작
                        fire.offer(new int[] {i, j, 0});
                    }

                }
            }
            bfsFire();
            // 시작위치가 가장자리면 바로 탈출함
            if (jx == 0 || jx == R - 1 || jy == 0 || jy == C - 1) {
                System.out.println(1);
                continue;
            }
            int result = bfsJihoon(jx, jy);
            if (result == -1) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(result);
            }
		}
        
        
    }
    // 불은 visited 필요 없음 -> 4만 넣어주고
    // 분마다 현재 불 위치를 리스트에 저장해.
    static void bfsFire() {

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
    static int bfsJihoon(int x, int y) {
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
