import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// MxN 판에 직사각형을 K개 그림
// 직사각형 좌표가 주어짐 -> 4개 점 왼쪽 아래 x y, 오른쪽 x y
// BFS 쓰는 문제 같아 -> 근데 좌표를 어떻게 표현할까가 문제일 거 같은데
// x y 를 배열 인덱스로 써볼까?

// bfs -> 방문했니? visited 필요
public class Main {
	static int M, N, K;
	static int[][] map;
	static boolean[][] visited;
	static int count;    // 영역의 개수
	static int w;
	static List<Integer> width;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		visited = new boolean[M][N];
		width = new ArrayList<>();
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int lx = Integer.parseInt(st.nextToken());
			int ly = Integer.parseInt(st.nextToken());
			int rx = Integer.parseInt(st.nextToken());
			int ry = Integer.parseInt(st.nextToken());
			
			for (int j = ly; j < ry; j++) {
				for (int k = lx; k < rx; k++) {
					map[j][k] = 1;
				}
			}
			
		}
		
		count = 0;
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && map[i][j] == 0) {
					bfs(i, j);
					count++;
					width.add(w);
				}
			}
		}
		
		Collections.sort(width);
		System.out.println(count);
		for (int i : width) {
			System.out.print(i + " ");
		}
		
	}
	private static void bfs(int x, int y) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {x, y});
		visited[x][y] = true;
		w = 1;
		
		while(!queue.isEmpty()) {
			int[] node = queue.poll();
			int cx = node[0];
			int cy = node[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (nx >= 0 && nx < M && ny >= 0 && ny < N && !visited[nx][ny] && map[nx][ny] == 0) {
					queue.offer(new int[] {nx, ny});
					visited[nx][ny] = true;
					w++;
				}
			}
		}
	}

}
