import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int size;
	static int[] arr;
	static int[] dp;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		size = Integer.parseInt(br.readLine());
		
		arr = new int[size];
		dp = new int[size];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < size; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.fill(dp, 1);
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[i] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < size; i++) {
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
	}

}
