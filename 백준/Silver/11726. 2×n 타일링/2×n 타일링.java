
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] dp;
	static int N;
	static int p = 10_007;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		dp = new int[1001];
		dp[0] = 1;
		dp[1] = 1;
		
		for (int i = 2; i < N + 1; i++) {
			dp[i] = ((dp[i - 1] % p) + (dp[i - 2]%p)) % p;
		}
		
		System.out.println(dp[N] % p);
	}

}
