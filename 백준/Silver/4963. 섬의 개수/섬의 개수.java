import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.StringTokenizer;

// 섬의 개수를 세라
// 대각선까지 있음. 8방 델타
// 1은 땅 0 바다
// 0 0 면 종료
// 

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static int w, h;
	static StringTokenizer st;
	static int count;
	
	static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
	static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		while(true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if (w == 0 && h == 0) {
				break;
			}
			map = new int[h][w];
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			visited = new boolean[h][w];
			count = 0;
			
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (!visited[i][j] && map[i][j] == 1) {
						bfs(i, j);
						count++;
					}
				}
			}
			System.out.println(count);
					
		}
		
	}
	private static void bfs(int x, int y) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {x, y});
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			int[] node = queue.poll();
			int cx = node[0];
			int cy = node[1];
			
			for (int i = 0; i < 8; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (nx >= 0 && nx < h && ny >= 0 && ny < w && !visited[nx][ny] && map[nx][ny] == 1) {
					queue.offer(new int[] {nx, ny});
					visited[nx][ny] = true;
				}
			}
		}
	}

}
