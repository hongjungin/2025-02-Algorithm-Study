import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 양방향
// 지역 번호 n, 아이템 수 t, 거리 r, 수색범위 m
// 어떤 자료구조를 써야하지? 
// 왜 플로이드워샬을 쓰는지 ? -> 모든 정점에서 모든 정점으로의 최단 거리 
public class Main {
	static int n, m, r, t;
	static int[][] game;
	static int[] items;
	static final int INF = Integer.MAX_VALUE / 10;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		items = new int[n + 1];
		game = new int[n + 1][n + 1];
		for (int i = 0; i < n + 1; i++) {
			Arrays.fill(game[i], INF);
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n + 1; i++) {
			items[i] = Integer.parseInt(st.nextToken());
//			System.out.print(items[i] + " ");
			game[i][i] = 0;
		}
		
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			game[a][b] = l;
			game[b][a] = l;
		}
		
		int maxItem = Integer.MIN_VALUE;
		int sum = 0;
		
		for (int k = 1; k < n + 1; k++) { // 경유지
			for (int i = 1; i < n + 1; i++) { // 출발지
				for (int j = 1; j < n + 1; j++) { //도착지
					if (game[i][j] > game[i][k] + game[k][j]) {
						game[i][j] = game[i][k] + game[k][j];
					}
				}
			}
			
		}
		
//		for (int i = 1; i < n + 1; i++) {
//			for (int j = 1; j < n + 1; j++) {
//				System.out.print(game[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		for (int i = 1; i < n + 1; i++) {
			sum = 0;
			for (int j = 1; j < n + 1; j++) {
				if (game[i][j] <= m) {
					sum += items[j];
				}
			}
			maxItem = Math.max(maxItem, sum);
		}
		System.out.println(maxItem);
	}

}
