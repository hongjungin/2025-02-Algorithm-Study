import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	// 일곱 난쟁이 키 합이 100
	// 난쟁이 키 모두 다름
	// 정답이 여러 개이면 아무거나 출력 -> 오름차순으로
	
	// 조합을 다 구하고 합이 100인걸 골라? -> 시간 오래 걸리지 않나?
	// 일단 combi 해 9C7
	static int N = 9;
	static int R = 7;
	static int[] height;
	static int[] selectSeven;
	static int sum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		height = new int[N];
		selectSeven = new int[R];
		//sumAll = 0;
		for (int i = 0; i < N; i++) {
			height[i] = Integer.parseInt(br.readLine());
			//sumAll += height[i];
		}
		// 오름차순 정렬
		Arrays.sort(height);
		
		combi(0,0);
	}

	private static void combi(int depth, int start) {
		if(depth == R) {  
			sum = 0;
			for (int i = 0; i < R; i++) {
				sum += selectSeven[i];
			}
			if (sum == 100) {
				for (int i = 0; i < R; i++) {
					System.out.println(selectSeven[i]);
				}
				System.exit(0);
			}
			return;
		}
		
		for (int i = start; i < N; i++) {
			selectSeven[depth] = height[i];
			combi(depth + 1, i + 1);
			selectSeven[depth] = 0;
		}
		
	}

}