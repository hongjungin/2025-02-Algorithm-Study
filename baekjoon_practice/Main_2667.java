import java.util.*;
import java.io.*;

// 집이 있어 1, 집이 없어 0
//

public class Main_2667 {

    static int N;
    static char[][] map;
    static boolean[][] visited;
    static List<Integer> list;
    static int[] dx = {-1, 0 , 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main (String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == '1') {
                    list.add(bfs(i, j));
                }
            }
        }

        list.sort((a, b) -> a - b);

        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }

    static int bfs(int startX, int startY) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;
        int count = 1;

        while (!queue.isEmpty()) {

            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && map[nx][ny] == '1') {
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    count++;
                }
            }

        }
        return count;
    }
}
