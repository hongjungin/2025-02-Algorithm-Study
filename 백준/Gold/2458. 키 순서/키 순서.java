import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 본인 앞 뒤로 다 더해서 전체 수가 나오면 키를 알 수 있어
public class Main {
	static int N, M, H;
	static List<Integer>[] graph;
	static List<Integer>[] graph2;
	static boolean[] visited1;
	static boolean[] visited2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N + 1];
		graph2 = new ArrayList[N + 1];
		
		for (int i = 0; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
			graph2[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[b].add(a);
			graph2[a].add(b);
		}
		
		H = 0;
		
		for (int i = 1; i < N + 1; i++) {
			visited1 = new boolean[N + 1];
			int bigCount = dfs(i, graph2, visited1);
			//System.out.println(bigCount);// 정방향
			visited2 = new boolean[N + 1];
			int smallCount = dfs(i, graph, visited2); // 역방향
			//System.out.println(smallCount);
			if (bigCount + smallCount == N + 1) {
				H++;
				//System.out.println("같아짐");
			}
		}
		System.out.println(H);
	}
	private static int dfs(int start, List<Integer>[] g, boolean[] visited) {
		visited[start] = true;
		int count = 1;
		for (int next : g[start]) {
			if (!visited[next]) {
				visited[next] = true;
				count += dfs(next, g, visited);
			} 
		}
		return count;
		
	}

}
