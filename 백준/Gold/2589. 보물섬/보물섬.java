import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 육지 L 바다 W -> 육지 1 바다 0으로 두자
// 한 칸 이동하는데 한 시간 걸림
// 보물은 서로 간에 최단 거리로 이동하는데 있어 가장 긴 시간이 걸리는 육지 두곳에 나뉘어 묻힘
// bfs 이용하자
// 보물이 묻힌 곳을 어떻게 정할까 -> 육지 사이으 최단 거리 중 max인 곳을 찾아라
public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int maxDistance;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				char c = line.charAt(j);
				if (c == 'L') {
					map[i][j] = 1;
				} else if (c == 'W') {
					map[i][j] = 0;
				}
			}
		}
		
		
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
		maxDistance = Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited = new boolean[N][M];
				if (map[i][j] == 1) {
					int m = bfs(i, j);
					maxDistance = Math.max(maxDistance, m);
				}
			}
		}
		System.out.println(maxDistance);
		
	}
	private static int bfs(int x, int y) {
		int time = 0; 
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {x, y, time});
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			int[] node = queue.poll();
			int cx = node[0];
			int cy = node[1];
			int dist = node[2];
			
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && map[nx][ny] == 1) {
					queue.offer(new int[] {nx, ny, dist + 1});
					visited[nx][ny] = true;
					time = dist + 1;
				}
			}
			
		}
		return time;
		
	}

}
