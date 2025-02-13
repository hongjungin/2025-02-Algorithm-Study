import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m; 
	static int pictures;
	static int[][] board;
	static boolean[][] visited;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	// 그림의 개수 -> bfs를 돌린 횟수
	// 가장 넓은 그림의 넓이 -> 한번 bfs를 돌렸을 때 각각 사이즈를 배열에 담아서 최대?
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 세로 n(행) 가로 m(열) 
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		// board 입력받기
		board = new int[n][m];
		visited = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}	
		int pictures = 0;
		int maxsize = Integer.MIN_VALUE;
		// 끝까지 bfs 탐색 
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j] && board[i][j] == 1) {
					int size = bfs(i, j);
					pictures++;
					maxsize = Math.max(maxsize, size);
				}
			}
		}
		
		if (pictures == 0) {
			maxsize = 0;
		}
		
		System.out.println(pictures);
		System.out.println(maxsize);
	}

	static int bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{x, y});
		visited[x][y] = true;
		int size = 1;
		
		while(!queue.isEmpty()) {
			int[] node = queue.poll();
			int cx = node[0];
			int cy = node[1];
			
			// 4방향 탐색
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && board[nx][ny] == 1) {
					queue.add(new int[] {nx, ny});
					visited[nx][ny] = true;
					size++;
				}
			}
		}
		return size;
	}

}
