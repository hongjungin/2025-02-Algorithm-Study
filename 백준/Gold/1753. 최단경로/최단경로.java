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
	
	static int V, E, start;
	static List<Node>[] graph;
	static int[] dist;
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(br.readLine());
		// 그래프 초기화
		graph = new ArrayList[V + 1];
		for (int i = 0; i < V + 1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph[u].add(new Node(v, w));
		}
		// 최소 비용 저장하는 리스트
		dist = new int[V + 1];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		dijkstra(start);
		
		for (int i = 1; i < V + 1; i++) {
			if(dist[i] == INF) {
				System.out.println("INF");
			} else {
				System.out.println(dist[i]);
			}
		}
	}
	
	private static void dijkstra(int s) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(s , 0));
		
		while (!pq.isEmpty()) {
			Node current = pq.poll();
			int cur = current.index;
			int curCost = current.cost;
			
			if (curCost > dist[cur]) continue;
			
			for (Node next : graph[cur]) {
				int nextNode = next.index;
				int nextCost = curCost + next.cost;
				
				if (dist[nextNode] > nextCost) {
					dist[nextNode] = nextCost;
					pq.offer(new Node(nextNode, nextCost));
				}
			}
			
		}
	}

}
