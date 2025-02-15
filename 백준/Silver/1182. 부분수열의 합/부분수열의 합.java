import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, S;
	static int[] input;
	static int count;
	static int sum;
	static boolean[] selected;
	// 부분 수열 중에서 ~ -> 부분집합으로 풀어
	// 부분 집합 필승 접근법 -> 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		input = new int[N];
		selected = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		subset(0);	
		
		System.out.println(count);
	}
	private static void subset(int depth) {
		if (depth == N) {
			countSum();
			return;
		}
		selected[depth] = true;
		subset(depth + 1);
		
		selected[depth] = false;
		subset(depth + 1);
	}
	private static void countSum() {
		int sum = 0;
		boolean isSelected = false;
		for (int i = 0; i < N; i++) {
			if (selected[i]) {
				isSelected = true;
				sum += input[i];
			}
		}
		if (!isSelected) {
			return;
		}
		
		if (sum == S) {
			count++;
		}

	}

}