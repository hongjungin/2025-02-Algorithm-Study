import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 집이 N 개 
// 모든 집을 칠하는 비용의 최솟값
// 1번 집의 색은 2번 집의 색과 같지 X
// N번 집의 색은 N-1번 집의 색과 같지 않음
// i번째 i-1번 i+1번 집의 색과 같지 않아여 함
public class Main {
	static int N;
	static int[][] RGB, dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		RGB = new int[N][3];
		dp = new int[N][3];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				RGB[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = RGB[0][0];
		dp[0][1] = RGB[0][1];
		dp[0][2] = RGB[0][2];
		
		for (int i = 1; i < N; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + RGB[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + RGB[i][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + RGB[i][2];
		}
		
		int result = Math.min(dp[N - 1][0], dp[N - 1][1]);
		int r = Math.min(result, dp[N - 1][2]);
		System.out.println(r);
	
	}
}
