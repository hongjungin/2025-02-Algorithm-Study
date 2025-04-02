import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node>{
		int index;
		int cost;
		public Node(int index, int cost) {
			this.index = index;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	static int N, M, start, end;
	static List<Node>[] graph;
	static int[] dist;
	static final int INF = Integer.MAX_VALUE;
 	public static void main(String[] args) throws IOException {
 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 		N = Integer.parseInt(br.readLine());
 		M = Integer.parseInt(br.readLine());
 		
 		graph = new ArrayList[N + 1];
 		for (int i = 0; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}
 		
 		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[u].add(new Node(v, w));
		}
 		
 		StringTokenizer st = new StringTokenizer(br.readLine());
 		start = Integer.parseInt(st.nextToken());
 		end = Integer.parseInt(st.nextToken());
 		
 		dist = new int[N + 1];
 		Arrays.fill(dist, INF);
 		dist[start] = 0;
 		
 		dijkstra(start);
 		
 		System.out.println(dist[end]);
	}
	private static void dijkstra(int s) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(s, 0));
		
		while (!pq.isEmpty()) {
			Node current = pq.poll();
			int cur = current.index;
			int curCost = current.cost;
			
			if (curCost > dist[cur]) continue;
			
			for (Node next : graph[cur]) {
				int nextNode = next.index;
				int nextCost = curCost + next.cost;
				
				if (nextCost < dist[nextNode]) {
					dist[nextNode] = nextCost;
					pq.offer(new Node(nextNode, nextCost));
				}
			}
		}
	}

}
