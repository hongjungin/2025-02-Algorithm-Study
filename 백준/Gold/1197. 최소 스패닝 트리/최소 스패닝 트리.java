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
		int start, end, weight;
		
		public Node(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {  // 여기에 우선 순위를 정해줌.
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());     // 정점 개수
		E = Integer.parseInt(st.nextToken());     // 간선 개수
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			pq.offer(new Node(start, end, weight));
		}
		
		parent = new int[V + 1];
		rank = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			parent[i] = i;   // 모든 정점의 부모를 자기 자신으로 설정
		}
		
		int mstWeight = 0;   // 최소 스패닝 트리 비용
		int connection = 0;       // mst 간선 개수
		
		while(!pq.isEmpty() && connection < V - 1) {   // mst는 N - 1개의 간선을 가짐
			Node node = pq.poll();    // 가중치가 가장 작은 간선 선택
			if (union(node.start, node.end)) {   // 유니온 연산 수행
				mstWeight += node.weight;
				connection++;
			}
			
		}
		
		System.out.println(mstWeight);
	}

	private static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b) return false;       // 이미 같은 집합이면 합치지 않음
		
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
		if (x == parent[x]) return x;    // 자기 자신이 부모면 루트 노드
		return parent[x] = find(parent[x]);
	}

	

}
