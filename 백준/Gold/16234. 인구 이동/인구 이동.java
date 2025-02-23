import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, L, R;
	static int[][] A;
	static int moveCount; // bfs 탐색 횟수
	static boolean isMoved;
	static boolean[][] visited;

	static int[] dx = { -1, 0, 1, 0 }; // 상우하좌
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		A = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		moveCount = 0;

		while (true) {
			visited = new boolean[N][N];
			isMoved = false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) {
						if (move(i, j)) {
							isMoved = true;
						}
					}
				}
			}

			// 종료조건
			if (!isMoved)
				break;
			moveCount++;
		} 
		
		System.out.println(moveCount);

	}

	private static boolean move(int x, int y) {
		Queue<int[]> queue = new ArrayDeque<>();
		List<int[]> union = new ArrayList<>();
		queue.add(new int[] { x, y });
		union.add(new int[] { x, y });
		visited[x][y] = true;

		int sum = A[x][y];
		int count = 1;

		while (!queue.isEmpty()) {
			int[] node = queue.poll();
			int cx = node[0];
			int cy = node[1];

			// 다음 방향 정하기
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];

				if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
					int sub = Math.abs(A[cx][cy] - A[nx][ny]);
					if (sub >= L && sub <= R) {
						queue.add(new int[] { nx, ny });
						union.add(new int[] { nx, ny });
						visited[nx][ny] = true;
						count++;
						sum += A[nx][ny];
					}
				}
			}
		}

		int unionPopulation = sum / count;
		// 연합이 일어나지 않음.
		if (count == 1) {
			return false;
		}

		for (int[] num : union) {
			A[num[0]][num[1]] = unionPopulation;
		}
		return true;             // 연합 일어남

	}

}