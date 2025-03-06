import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int T, N;
	static int[] input;
	static List<Integer>[] graph;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			
			input = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				input[i] = Integer.parseInt(st.nextToken());
				
			}
			
			graph = new ArrayList[N + 1];
			for (int i = 1; i <= N; i++) {
				graph[i] = new ArrayList<>();
			}
			
			for (int i = 1; i <= N; i++) {
				int a = input[i-1]; 
				graph[i].add(a);
			}
			int count = 0;
			visited = new boolean[N + 1];
			for (int i = 1; i <= N; i++) {
				if (!visited[i]) {
					bfs(i);
					count++;
				}
			}
			System.out.println(count);
		}
	}
	private static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			
			for (int next : graph[node]) {
				if (!visited[next]) {
					queue.add(next);
					visited[next] = true;
				}
			}
		}
	}

}
