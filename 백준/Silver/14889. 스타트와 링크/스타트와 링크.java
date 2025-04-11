
// 절반으로 나눠 -> combi
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, minResult;
	static int[][] S;
	static int[] allTeam;
	static boolean[] visited;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		S = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		minResult = Integer.MAX_VALUE;
		visited = new boolean[N];
		combi(0, 1);
		System.out.println(minResult);
	}
	private static void combi(int depth, int start) {
		if (depth == N/2) {
			List<Integer> teamA = new ArrayList<>();
			List<Integer> teamB = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				if (visited[i]) {
					teamA.add(i);
				}else {
					teamB.add(i);
				}
			}
			
			int sumA = 0;
			int sumB = 0;
			for (int i = 0; i < teamA.size(); i++) {
				for (int j = 0; j < teamA.size(); j++) {
					if (i != j) {
						sumA += S[teamA.get(i)][teamA.get(j)];
						sumB += S[teamB.get(i)][teamB.get(j)];
						
//						System.out.println(sumA + " " + sumB);
					}
				}
			}
			
			int d = Math.abs(sumA - sumB);
			minResult = Math.min(minResult, d);
			return;
		}
		
		for (int i = start; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				combi(depth + 1,i + 1);
				visited[i] = false;
			}
			
		}
	}

}
