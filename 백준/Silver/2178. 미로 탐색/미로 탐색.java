
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 1 : 이동 O 0 : 이동 X
// (1,1) 에서 출발해서 (N,M)위치로 이동해야할 떄 최소 칸 
// 최소 -> bfs 시용
public class Main {
	static int N, M, result;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		result = Integer.MAX_VALUE;
		bfs(0, 0);
		System.out.println(result);
	}
	private static void bfs(int x, int y) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {x, y, 1});
		visited[x][y] = true;
		
		while (!queue.isEmpty()) {
			int[] node = queue.poll();
			int cx = node[0];
			int cy = node[1];
			int dist = node[2];
			
			if (cx == N - 1 && cy == M - 1) {
				result = Math.min(result, dist);
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
					continue;
				}
				
				
				if (!visited[nx][ny] && map[nx][ny] == '1') {
					visited[nx][ny] = true;
					queue.offer(new int[] {nx, ny, dist + 1});
				}
			}
		}
		
	}

}
