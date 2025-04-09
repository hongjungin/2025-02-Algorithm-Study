import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	static int N, max;
	static int[][] people;
	static int[] friend;
	static final int INF = Integer.MAX_VALUE/10;
	public static void main(String[] args) throws Exception, IOException { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		people = new int[N + 1][N + 1];
		for (int i = 0; i < N + 1; i++) {
			people[i][i] = 0;
			Arrays.fill(people[i], INF);
		}
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (a == -1 || b == -1) {
				break;
			}
			people[a][b] = 1;
			people[b][a] = 1;
		}
		
		for (int k = 0; k < N + 1; k++) {
			for (int i = 0; i < N + 1; i++) {
				for (int j = 0; j < N + 1; j++) {
					if (people[i][j] > people[i][k] + people[k][j]) {
						people[i][j] = people[i][k] + people[k][j];
					}
				}
			}
		}
		friend = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			max = 0;
			for (int j = 1; j < N + 1; j++) {
				if(i!=j)
					max = Math.max(max, people[i][j]);
			}
			friend[i] = max;
		}

		int minF = Integer.MAX_VALUE;
		int index = 0;
		for (int i = 1; i < N + 1; i++) {
			minF = Math.min(minF, friend[i]);
		}
		StringBuilder sb = new StringBuilder();
		int count = 0;
		for (int i = 1; i < N + 1; i++) {
			if (friend[i] == minF) {
				count++;
			}
		}
		sb.append(minF).append(" ").append(count).append("\n");
		for (int i = 1; i < N + 1; i++) {
			if (friend[i] == minF) {
				sb.append(i).append(" ");
			}
		}
		System.out.println(sb);
	}

}
