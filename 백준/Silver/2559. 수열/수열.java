import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static int[] temp;
	static int sum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 입력 받기
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		temp = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			temp[i] = Integer.parseInt(st.nextToken());
		}
		// 미리 합 구하기
		int sum = 0;
		for (int i = 0; i < K; i++) {
			sum += temp[i];
		}
		
		
		int maxSum = sum;
		// 맨 앞을 빼고 맨 뒤를 더해
		for (int i = K; i < N; i++) {
			sum = sum + temp[i] - temp[i - K];
			maxSum = Math.max(maxSum, sum);
		}
		
		System.out.println(maxSum);
	}
}