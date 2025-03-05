import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int V, E;
	static PriorityQueue<Node> pq = new PriorityQueue<>();
	static int[] parent, rank;
	static class Node implements Comparable<Node> {
		public Node(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		int start, end, weight;

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		V = Integer.parseInt(br.readLine());     // 정점 개수
		E = Integer.parseInt(br.readLine());     // 간선 개수
		
		for (int i = 0; i < E; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			pq.offer(new Node(start, end, weight));
		}
		
		parent = new int[V + 1];
		rank = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			parent[i] = i;              // 모든 종점의 부모를 나로 둠
		}
		
		int mstWeight = 0;
		int connection = 0;
		
		while(!pq.isEmpty() && connection < V - 1) {
			Node node = pq.poll();
			if (union(node.start, node.end)) {
				mstWeight += node.weight;
				connection++;
			}
		}
        System.out.println(mstWeight);
		
	}
	private static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b) return false;
		if (rank[a] < rank[b]) {
			rank[b] += rank[a];
			parent[a] = b;
		} else {
			rank[a] += rank[b];
			parent[b] = a;
		}
		return true;
	}
	private static int find(int x) {
		if (x == parent[x]) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}

}
