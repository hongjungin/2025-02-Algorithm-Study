import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// n개의 도시 m 개의 버스
// 비용
// 모든 도시의 쌍에서 비용 최솟값 -> n <= 100 이므로 플로이드 워샬

public class Main {
	static int n, m;
	static int[][] bus;
	static final int INF = Integer.MAX_VALUE / 10;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		bus = new int[n + 1][n + 1];
		for (int i = 0; i < n + 1; i++) {
			Arrays.fill(bus[i], INF);
			bus[i][i] = 0;
		}
		
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			bus[a][b] = Math.min(bus[a][b], c);
		}
		
		for (int k = 1; k < n + 1; k++) { // 경유지
			for (int i = 1; i < n + 1; i++) {
				for (int j = 1; j < n + 1; j++) {
					if (bus[i][j] > bus[i][k] + bus[k][j]) {
						bus[i][j] = bus[i][k] + bus[k][j];
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (bus[i][j] == INF) {
					sb.append("0 ");
				} else {
					sb.append(bus[i][j]).append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
