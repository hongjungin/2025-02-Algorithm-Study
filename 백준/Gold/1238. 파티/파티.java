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
	static int N, M, X;
	static List<Node>[] graph;
	static int[] time;
	static int[][] party;
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph[u].add(new Node(v, w));
		}
		party = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			dijkstra(i);
		}
		
		int maxTime = Integer.MIN_VALUE;
		for (int i = 1; i < N + 1; i++) {
			int partyTime = party[i][X] + party[X][i];
			maxTime = Math.max(maxTime, partyTime);
		}
		
		System.out.println(maxTime);
	}
	private static void dijkstra(int start) {
		time = new int[N + 1];
		Arrays.fill(time, INF);
		time[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		
		while (!pq.isEmpty()) {
			Node current = pq.poll();
			int cur = current.index;
			int curCost = current.cost;
			
			if (curCost > time[cur]) {
				continue;
			}
			
			for (Node next : graph[cur]) {
				int nextNode = next.index;
				int nextCost = curCost + next.cost;
				
				if (nextCost < time[nextNode]) {
					time[nextNode] = nextCost;
					pq.offer(new Node(nextNode, nextCost));
				}
			}
		}
		party[start] = time;
	}

}
