import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] dp;
	static int N;

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		dp = new int[1_000_001];
		dp[0] = 0;
		if (N >= 1) dp[1] = 0;
		if (N >= 2) dp[2] = 1;
		if(N >= 3) {
			for (int i = 3; i < N + 1; i++) {
				dp[i] = dp[i-1] + 1;
				if(i % 3 == 0) {
					dp[i] = Math.min(dp[i], dp[i/3] + 1);
				}
				if (i % 2 == 0) {
					dp[i] = Math.min(dp[i], dp[i/2] + 1);
				}
			}
		}
		System.out.println(dp[N]);
	}
}
