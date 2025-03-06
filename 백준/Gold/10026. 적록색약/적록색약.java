import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

// 
public class Main {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static StringTokenizer st;
	static int count1, count2;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				if (line.charAt(j) == 'R') {
					map[i][j] = 0;
				} else if (line.charAt(j) == 'G') {
					map[i][j] = 1;
				} else if (line.charAt(j) == 'B') {
					map[i][j] = 2;
				}
			}
		}
		
		
		visited = new boolean[N][N];
		int count1 = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					bfs(i, j);
					count1++;
				}
			}
		}
		
		visited = new boolean[N][N];
		int count2 = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					map[i][j] = 0;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {			
				if (!visited[i][j]) {
					bfs(i, j);
					count2++;
				}
			}
		}
		
		System.out.println(count1 + " " + count2);
	}
	private static void bfs(int x, int y) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {x, y});
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			int node[] = queue.poll();
			int cx = node[0];
			int cy = node[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && (map[cx][cy] == map[nx][ny])) {
					queue.offer(new int[] {nx, ny});
					visited[nx][ny] = true;
				}
			}
		}
		
	}
	
	
}
