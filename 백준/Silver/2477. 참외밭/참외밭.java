import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] ground;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		ground = new int[6][2];
		
		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				ground[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] weight = new int[6];
		
		for (int i = 0; i < 5; i++) {
			
			weight[i] = ground[i][1] * ground[i + 1][1];
		}
		weight[5] = ground[0][1] * ground[5][1];
		
		int maxWeight = 0;
		int sum = 0;
		for (int i = 0; i < 6; i++) {
			sum += weight[i];
			maxWeight = Math.max(maxWeight, weight[i]);
		}
		
		int result = 0;
		result = sum - 2 * maxWeight;
		
		
		System.out.println(result * N);
	}

}
