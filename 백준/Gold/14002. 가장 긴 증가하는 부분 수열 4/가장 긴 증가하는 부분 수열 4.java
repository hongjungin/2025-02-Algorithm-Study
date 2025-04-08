import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int size;
	static int[] arr;
	static int[] dp;
	static int[] trace;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		size = Integer.parseInt(br.readLine());
		
		arr = new int[size];
		dp = new int[size];
		trace = new int[size];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < size; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.fill(dp, 1);
		Arrays.fill(trace, -1);
		
		int max = Integer.MIN_VALUE;
		int lastIndex = 0;
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
//					System.out.println(i + " " + j);
					trace[i] = j;
				}
			}
			
			if (dp[i] > max) {
				max = dp[i];
				lastIndex = i;
//				System.out.println(lastIndex);
			}
		}
		
		List<Integer> lis = new ArrayList<>();
		
		while(lastIndex != -1) {
			lis.add(arr[lastIndex]);
			lastIndex = trace[lastIndex];
		}
		
		Collections.reverse(lis);
		
		System.out.println(lis.size());
		for (int i : lis) {
			System.out.print(i + " ");
		}
		
	}

}
