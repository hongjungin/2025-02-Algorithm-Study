import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 두 원소가 같은 집합에 포함되어 있는지 연산을 수행 -> 서로소 집합 / 유니온 파인드 적용

public class Main {
	static int n, m;
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		parent = new int[n+1];
		// 초기화
		for (int i = 0; i < n + 1; i++) {
			parent[i] = i; // 내 자신이 부모
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (start == 0) {
				union(a, b);
			} else if (start == 1) {
				if (find(a) == find(b)) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}
	}
	private static int find(int a) {
		if (parent[a] == a) {
			return parent[a];
		}
		return parent[a] = find(parent[a]);
		
	}
	private static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		if (rootA != rootB) {
			parent[rootB] = rootA;
		}
	}

}
