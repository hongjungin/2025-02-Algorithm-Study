import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, x;
	static int[] input;
	static int[] nums;
	static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		input = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		x = Integer.parseInt(br.readLine());
		
		Arrays.sort(input);
		
		int right = n - 1;
		int left = 0;
		int sum = 0;
		count = 0;
		
		while (true) {
			if (left >= right) {
				break;
			}
			
			sum = input[left] + input[right];
			
			if (sum == x) {
				count++;
				left++;
				right--;
			} else if (sum > x) {
				right--;
			} else if (sum < x) {
				left++;
			}
		
		}
		
		System.out.println(count);
	}

}
