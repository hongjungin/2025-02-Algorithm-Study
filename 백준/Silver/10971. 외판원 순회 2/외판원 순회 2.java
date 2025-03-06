import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1번부터 N번까지 도시 -> 모두 거쳐서 다시 원래 도시로 -> permutation 이용해서 풀어보자
// 비용은 W[i][j] -> i에서 j로 가는 비용
// W[i][i]는 항상 0
// 가장 적은 비용 >>>

public class Main {
	static int N;
	static int[][] W;
	static boolean[] visited;
	static int[] nums;
	static int minCost;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		W = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		nums = new int[N];
		visited = new boolean[N];
		minCost = Integer.MAX_VALUE;
		perm(0);
		System.out.println(minCost);
	}

	private static void perm(int depth) {
		if (depth == N) {
			// {1, 2, 3, 4} 이런 순서가 정해진 것임.
			int sum = 0;
			for (int i = 0; i < N - 1; i++) {
				if (W[nums[i]][nums[i+1]] == 0) return;
				sum += W[nums[i]][nums[i+1]];
			}
			if (W[nums[N-1]][nums[0]] == 0) return;
			sum += W[nums[N-1]][nums[0]];
			minCost = Math.min(sum, minCost);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (visited[i]) continue;		
			visited[i] = true;
			nums[depth] = i;
			perm(depth + 1);
			visited[i] = false;
		} 
	}

}
