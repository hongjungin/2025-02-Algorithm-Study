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
	static int N, E, v1, v2;
	static List<Node>[] graph;
	static int[] dist, dist2;
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[a].add(new Node(b, c));
			graph[b].add(new Node(a, c));
		}
		
		st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());
		
		int[] distFrom1 = dijkstra(1);
		int[] distFromV1 = dijkstra(v1);
		int[] distFromV2 = dijkstra(v2);
		
		int r1 = distFrom1[v1];
		int r2 = distFromV1[v2];
		int r3 = distFromV2[N];
		int r4 = distFrom1[v2];
		int r5 = distFromV2[v1];
		int r6 = distFromV1[N];
		int route1 = 0;
		int route2 = 0;
		
		if (r1 == INF || r2 == INF || r3 == INF) {
			route1 = INF;
		} else {
			route1 = r1 + r2 + r3;
		}
		if (r4 == INF || r5 == INF || r6 == INF) {
			route2 = INF;
		} else {
			route2 = r4 + r5 + r6;
		}
		
		int result = Math.min(route1, route2);
		
		if (result == INF) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}
		
	}
	private static int[] dijkstra(int start) {
		int[] dist = new int[N + 1];
	    Arrays.fill(dist, INF);
	    dist[start] = 0;
	    
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		
		while (!pq.isEmpty()) {
			Node current = pq.poll();
			int cur = current.index;
			int curCost = current.cost;
			
			if (curCost > dist[cur]) {
				continue;
			}
			
			for (Node next : graph[cur]) {
				int nextNode = next.index;
				int nextCost = curCost + next.cost;
				
				if (nextCost < dist[nextNode]) {
					dist[nextNode] = nextCost;
					pq.offer(new Node(nextNode, nextCost));
				}
			}
		}
		return dist;
	}

}
