import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// n가지 종류의 동전 
// 가치 합 k
public class Main {
	static int n, k;
	static int[] V;
	static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		V = new int[n];
		for (int i = 0; i < n; i++) {
			V[i] = Integer.parseInt(br.readLine());
		}
		
		dp = new int[k + 1];
		dp[0] = 1;
		for (int i : V) {
			for (int j = i; j < k + 1; j++) {
				dp[j] += dp[j - i];
			}
		}
		
		System.out.println(dp[k]);
	}

}
