import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] parents;
	static int[] cities;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		parents = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			parents[i] = i;
		}
		
		for (int i = 1; i < N + 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N + 1; j++) {
				int city = Integer.parseInt(st.nextToken());
				if (city == 1) {
					union(i, j);
				}
			}
		}
//		for (int i = 1; i < N + 1; i++) {
//			System.out.print(parents[i] + " ");
//		}
//		// M개의 여행 경로에 대한 정답 검증
		cities = new int[M];
		StringTokenizer st = new StringTokenizer(br.readLine());
		boolean isPossible = true;
		for (int i = 0; i < M; i++) {
			cities[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int j = 0; j < M - 1; j++) {
			if (find(cities[j]) != find(cities[j+1])) {
				isPossible = false;
			} 
		}
		
		if (isPossible) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		
	}
	
	public static int find(int x) {
		if(parents[x] == x ) return x;
		else return parents[x] = find(parents[x]);
	}
	
	public static void union(int a, int b) {
		int A = find(a);
		int B = find(b);
		if(A > B) parents[A] = B;
		else parents[B] = A;
	}
}
