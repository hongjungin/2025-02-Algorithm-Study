import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 좌측 상단에서 말이 움직이기 시작
public class Main {
	static int R, C;
	static int[][] board;
	static boolean[] visited;
	static int count;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		board = new int[R][C];
		visited = new boolean[26];
		
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				board[i][j] = line.charAt(j) - 'A';
			}
		}
		visited[board[0][0]] = true;
		count = 1;
		dfs(0, 0, 1);
		System.out.println(count);
	}
	private static void dfs(int x, int y, int depth) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			int dist = depth + 1;
			if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
				continue;
			}
			if (!visited[board[nx][ny]]) {
				visited[board[nx][ny]] = true;
				count = Math.max(count, dist);
				dfs(nx, ny, dist);
				visited[board[nx][ny]] = false;
			}
		}
	}

}
