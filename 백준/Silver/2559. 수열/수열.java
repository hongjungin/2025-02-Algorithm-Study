import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	// 고정 크기 -> 배열로 구현해야겠다
	static int N, K;
	static int[] temp;
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
		
		// 투포인터 활용해보자
		
		int maxSum = Integer.MIN_VALUE;
		for (int left = 0; left < N - K + 1; left++) {
			int sum = 0;
			for (int right = left; right < K + left; right++) {
				sum += temp[right];
			}
			if(maxSum < sum) {
				maxSum = sum;
			}
		}
		
		System.out.println(maxSum);
	}

}
