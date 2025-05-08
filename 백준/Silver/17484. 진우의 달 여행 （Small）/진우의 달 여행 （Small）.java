import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 지구 ->  달 (방향 3가지)
// 같은 방향 연속으로 x
// 연료 최소
public class Main {
	static int N, M, minCost;
	static int[][] space;
	static int[] dx = {1, 1, 1};
	static int[] dy = {-1, 0, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		space = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				space[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		minCost = Integer.MAX_VALUE;
		for (int i = 0; i < M; i++) {
			dfs(0, i, -1, space[0][i]);
		}
		System.out.println(minCost);
	}
	
	static void dfs(int x, int y, int d, int s) {
		// 종료
		if (x == N - 1) {
			minCost = Math.min(minCost, s);
			return;
		}
		
		int cx = x;
		int cy = y;
		int dist = d;
		int sum = s;
		
		for (int i = 0; i < 3; i++) {
			if (dist != i) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
					continue;
				}
				
				sum += space[nx][ny];
				dfs(nx, ny, i, sum);
				sum -= space[nx][ny];
			}
		}
		
	}
}
