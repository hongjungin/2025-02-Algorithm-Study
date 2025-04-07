import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 배낭 최대한 가치있게 쌈
// 필요한 물건 N개
// 각 물건은 무게 W 가치 V
// 배낭은 최대 K만큼 무게

public class Main {
	static int N, K;
	static int[] W;
	static int[] V;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		W = new int[N + 1];
		V = new int[N + 1];
		
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[N + 1][K + 1];
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < K + 1; j++) {
				if (j < W[i]) {  // 못 담아
					dp[i][j] = dp[i-1][j];
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - W[i]] + V[i]);
				}
			}
		}
		
		System.out.println(dp[N][K]);
	}

}
