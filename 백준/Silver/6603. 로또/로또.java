import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int k;
	static int R = 6;
	static int[] nums;
	static int[] S;
	// 입력 줄의 첫번째 수는 k
	// 그 다음 수들은 집합 S
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 입력값 받기
			k = Integer.parseInt(st.nextToken());
			
			if(k == 0) break;
			
			S = new int[k];
			nums = new int[R];
			for (int i = 0; i < k; i++) {
				S[i] = Integer.parseInt(st.nextToken());
			}
			
			combi(0,0);
			System.out.println();
		}
		
	}
	private static void combi(int depth, int start) {
		if (depth == R) {
			for (int i = 0; i < R; i++) {
				System.out.print(nums[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = start; i < k; i++) {
			nums[depth] = S[i];
			combi(depth + 1, i + 1);
			nums[depth] = 0;
		}
	}

}