import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] indegree;
	static ArrayList<Integer>[] adjList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		indegree = new int[N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			adjList[start].add(end);
			indegree[end]++;
		}
		
		ArrayDeque<Integer> q = new ArrayDeque<>();
		for (int i = 1; i < N + 1; i++) {
			if (indegree[i] == 0) {
				q.offer(i);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while (!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur).append(" ");
			
			for (int next : adjList[cur]) {
				indegree[next]--;
				if (indegree[next] == 0) {
					q.offer(next);
				}
			}
		}
		
		System.out.println(sb);
	}

}
