import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.StringTokenizer;

// 익은 토마토 -> 위 아래 왼쪽 오른쪽 앞 뒤
// 0: 안익은 토마토 1:익은 토마토 -1:토마토가 들어있지 않은 칸
public class Main {
	static int M, N, H; // 가로 세로 높이
	static int[][][] box;
	static boolean[][][] visited;
	static int[] dx = {-1, 1, 0, 0, 0, 0};
	static int[] dy = {0, 0, -1, 1, 0, 0};
	static int[] dz = {0, 0, 0, 0, -1, 1};
	static Queue<int[]> queue;
	static int day;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		box = new int[H][N][M];
		visited = new boolean[H][N][M];
		queue = new ArrayDeque<>();
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					box[i][j][k] = Integer.parseInt(st.nextToken());
					if (box[i][j][k] == 1) {
						queue.offer(new int[] {i, j, k, 0});
						visited[i][j][k] = true;
					}
				}
			}	
		}
		
//		for (int i = 0; i < H; i++) {
//			for (int j = 0; j < N; j++) {
//				for (int k = 0; k < M; k++) {
//					System.out.print(box[i][j][k] + " ");
//				}
//			}	
//		}
		day = 0;
		int minDay = 0;
		minDay = bfs();
		System.out.println(minDay);
	}

	private static int bfs() {
		int size = queue.size();
		
		for (int i = 0; i < size; i++) {
			while (!queue.isEmpty()) {
				int[] node = queue.poll();
				int cz = node[0];
				int cy = node[1];
				int cx = node[2];
				day = node[3];
				
				for (int j = 0; j < 6; j++) {
					int nz = cz + dz[j];
					int ny = cy + dy[j];
					int nx = cx + dx[j];
					
					if (nz >= 0 && nz < H && ny >= 0 && ny < N && nx >= 0 && nx < M) {
						if (box[nz][ny][nx] != -1 && !visited[nz][ny][nx]) {
							queue.offer(new int[] {nz, ny, nx, day+1});
							visited[nz][ny][nx] = true;
						}
					}
				}
			}
			
		}
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (!visited[i][j][k] && box[i][j][k] == 0) {
						return -1;
					}
				}
			}
		}
		return day;
		
		
	}

}
