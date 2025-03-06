import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 아기 상어 
// 안전거리 = 그 칸과 가장 거리가 가까운 아기 상어와의 거리
// 두 칸의 거리는 하나의 칸에서 다른 칸으로 가기 위해서 지나야 하는 칸의 수
// 안전거리가 가장 큰 칸을 구해
// 0 빈칸 1 아기 상어

public class Main {
	static int N, M;
	static int d;
	static int[][] map;
	static int[][] distance;
	static StringTokenizer st;
	static int maxDistance = Integer.MIN_VALUE;
	static Queue<int[]> shark;
	static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
	static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		distance = new int[N][M];
		shark = new ArrayDeque<>();
		
		for (int i = 0; i < N; i++) {
			Arrays.fill(distance[i], -1);
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					shark.add(new int[] {i, j, 0}); // 상어 위치 기록 
					distance[i][j] = 0;
				}
			}
		}
	
		bfs();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				maxDistance = Math.max(maxDistance, distance[i][j]);
			}
		}
		System.out.println(maxDistance);
	}

	private static void bfs() {
		while(!shark.isEmpty()) {
			int[] node = shark.poll();
			int cx = node[0];
			int cy = node[1];
			int dist = node[2];
			
			for (int i = 0; i < 8; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];				
				
				// 8방 탐색을 했는데 1을 만나면 종료
				if (nx >= 0 && nx < N && ny >= 0 && ny < M) {  // 범위 안에 있을 때					
					if (distance[nx][ny] == -1) {
						distance[nx][ny] = dist + 1;
						shark.offer(new int[] {nx, ny, dist + 1});
					}
				}
			}			
			
		}
		return;	
	}

}
