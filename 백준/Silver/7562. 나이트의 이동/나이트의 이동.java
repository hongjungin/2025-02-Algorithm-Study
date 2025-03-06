import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 나이트는 한칸을 상하좌우 이동 -> 한칸 대각선
public class Main {
	static int T, N;
	static int startX, startY, moveX, moveY;
	static int moveCount;
	static Queue<int[]> queue;
	static int[][] chess;
	static boolean[][] visited;
	static StringTokenizer st;
	
	static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine()); // 한 변의 길이
			// 시작 위치
			st = new StringTokenizer(br.readLine());
			startX = Integer.parseInt(st.nextToken());
			startY = Integer.parseInt(st.nextToken());
			// 이동하려는 위치
			st = new StringTokenizer(br.readLine());
			moveX = Integer.parseInt(st.nextToken());
			moveY = Integer.parseInt(st.nextToken());
			
			chess = new int[N][N];
			visited = new boolean[N][N];
			int count = bfs(startX, startY);
			System.out.println(count);
			
			queue.clear();
		}
	}

	private static int bfs(int x, int y) {
		queue = new ArrayDeque<>();
		queue.offer(new int[] {x, y, 0});
		visited[x][y] = true;
		int dist = 0;
		
		while(!queue.isEmpty()) {
			int[] node = queue.poll();
			int cx = node[0];
			int cy = node[1];
			dist = node[2];
			
			if (cx == moveX && cy == moveY) return dist;
			
			for (int i = 0; i < 8; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (nx == moveX && ny == moveY) {
					dist += 1;
					return dist;
				}
				
				if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
					queue.offer(new int[] {nx, ny, dist + 1});
					visited[nx][ny] = true;
				}
			}
		}
		return dist;
	}

}
