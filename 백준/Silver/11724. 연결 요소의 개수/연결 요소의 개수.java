// 방향 없는 그래프
// 그래프를 형성해서 bfs를 돌려 -> 연결된 묶음 개수 세는 것.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static List<Integer>[] graph;
	static boolean[] visited;
	static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new List[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph[u].add(v);
			graph[v].add(u);
		}
		// 그래프 만듦.
		
		visited = new boolean[N + 1];
		count = 0;
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				bfs(i);
				count++;
			}
		}
		System.out.println(count);
	}
	private static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		visited[start] = true;
		queue.offer(start);
		
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			
			for (int next : graph[node]) {
				if(!visited[next]) {
                    visited[next] = true;
					queue.offer(next);
				}
			}
		}
	}

}
