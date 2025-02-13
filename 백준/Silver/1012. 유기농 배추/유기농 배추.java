import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	// 최소 -> bfs로 접근
	// 0 : 배추 X, 1 : 배추 O

	static int T, N, M, cabbage;
	static int warm;
	static int[][] field;
	static boolean[][] visited;

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 입력값 받기
		T = Integer.parseInt(st.nextToken());

		for (int k = 0; k < T; k++) {
			StringTokenizer line = new StringTokenizer(br.readLine());
			M = Integer.parseInt(line.nextToken());
			N = Integer.parseInt(line.nextToken());
			cabbage = Integer.parseInt(line.nextToken());
			// 배열 초기화
			field = new int[M][N];
			visited = new boolean[M][N];

			// 배열 채우기
			for (int i = 0; i < cabbage; i++) {
				StringTokenizer input = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(input.nextToken());
				int y = Integer.parseInt(input.nextToken());

				if (x >= 0 && x < M && y >= 0 && y < N) {
					field[x][y] = 1;
				}
			}
			// 만약 다음 경로가 없다면 ?
			// bfs가 끝나면 warm++ 해주고 또 돌려야함.
			// 모든 좌표 순회하면서 bfs 탐색
			int warm = 0;
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j] && field[i][j] == 1) {
						bfs(i, j);
						warm++;
					}
				}
			}

			System.out.println(warm);
		}

	}

	// bfs를 돌리고 끝나면 warm 개수 + 1
	private static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { x, y });
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			int[] node = queue.poll();
			int cx = node[0];
			int cy = node[1];

			// 네 방향 탐색
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];

				if (nx >= 0 && nx < M && ny >= 0 && ny < N && !visited[nx][ny] && field[nx][ny] == 1) {
					queue.add(new int[] { nx, ny });
					visited[nx][ny] = true;
				}
			}

		}
	}

}