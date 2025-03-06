import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] input;
	static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		input = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(input);
		
		int left = 0;
		int right = input.length - 1;
		int sum = 0;
		count = 0;
		
		while(left < right) {
			sum = input[left] + input[right];
			if (sum < M) {
				left++;
			} else if (sum == M) {
				count++;
				left++;
			} else if (sum > M) {
				right--;
			}
		}
		
		
		System.out.println(count);
	}

}
