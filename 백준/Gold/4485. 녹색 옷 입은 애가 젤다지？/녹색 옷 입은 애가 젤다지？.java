import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node> {
		int x, y, cost;
		Node(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
		
	}
	
	
	static int N;
	static int[][] map, dist;
	static int[] dx = {-1, 0, 1, 0}; 
    static int[] dy = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = 1;
		StringBuilder sb = new StringBuilder();
		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0) {
				break;
			}
			
			map = new int[N][N];
			dist = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
			
			dijkstra();
			
			sb.append("Problem ").append(t).append(": ").append(dist[N-1][N-1]).append("\n");
			t++;
		}
		System.out.println(sb);
	}
	private static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(0, 0, map[0][0]));
		dist[0][0] = map[0][0];
		
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
					continue;
				}
				
				int newCost = dist[cur.x][cur.y] + map[nx][ny];
				if (newCost < dist[nx][ny]) {
					dist[nx][ny] = newCost;
					pq.offer(new Node(nx, ny, newCost));
				}
			}
		}
		
		
	}

}
