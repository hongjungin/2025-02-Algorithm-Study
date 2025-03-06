import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 0 : 공기 1 : 치즈
//
public class Main {
	static int N, M;
	static int[][] board;
	static boolean[][] visited;
	static Queue<int[]> meltingCheese;
	static Queue<int[]> nextCheese;
	static Queue<int[]> cheese;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new int[N][M];
		// 1인데 주변에 0이 없는 치즈 , 1밖에 없는 치즈 이렇게 큐 나눔
		meltingCheese = new ArrayDeque<>();
		cheese = new ArrayDeque<>();
		nextCheese = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 1) {
					cheese.offer(new int[] { i, j }); // 미리 치즈 부분을 찾아
				}
			}
		}
		
		int time = 0;
		int size = 0;
		while (true) {	
			visited = new boolean[N][M];
			size = cheese.size();
			checkAir(0,0);
			findMeltingCheese(); // 녹일 치즈, 남는 치즈 따로 큐에 넣어놓음
			meltCheese(); // 녹일 치즈 녹이고 다음 치즈를 옮겨줘야함
			time++;
			if (cheese.isEmpty()) {
				break;
			}
			size = cheese.size();
		}
		System.out.println(time);
		System.out.println(size);

	}

	private static void checkAir(int x, int y) {
		Queue<int[]> air = new ArrayDeque<>();
		air.offer(new int[] {x, y});
		visited[x][y] = true;
		
		while(!air.isEmpty()) {
			int[] node = air.poll();
			int cx = node[0];
			int cy = node[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];

				if (nx >= 0 && nx < N && ny >= 0 && ny < M && board[nx][ny] == 0 && !visited[nx][ny]) {
					air.offer(new int[] {nx, ny});
					visited[nx][ny] = true;
				}
			}
		}
	}

	private static void meltCheese() {
		while(!meltingCheese.isEmpty()) {
			int[] c = meltingCheese.poll();
			int x = c[0];
			int y = c[1];			
			board[x][y] = 0;
		}
		
		cheese = nextCheese;
		nextCheese = new ArrayDeque<>();
	}

	private static void findMeltingCheese() {

		while (!cheese.isEmpty()) {
			int[] node = cheese.poll();
			int cx = node[0];
			int cy = node[1];
			int air = 0;

			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];

				if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if (board[nx][ny] == 0 && visited[nx][ny]) {
						air++;
					}
				}
			}
			if (air > 0) {
				meltingCheese.offer(new int[] { cx, cy });
//				visited[cx][cy] = true;
			} else if (air == 0) {
				nextCheese.offer(new int[] { cx, cy });
//				visited[cx][cy] = true;
			}
			
		}
	}

}