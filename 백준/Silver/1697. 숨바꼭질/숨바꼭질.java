import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 수빈이 위치 : N -> 걷거나 순간이동할 수 있음
// 동생 위치 : K
// 갈 수 있는 방법이 X-1 / X+1 / 2*X
public class Main {
	static int N, K;
	static List<Integer>[] node; // 노드의 인덱스가 위치. 그 노드에 갈 수 있는 위치를 그래프로 저장
	static int[] distance;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int max = 100000;
		node = new ArrayList[max + 1];
		
		for (int i = 0; i <= max; i++) {
			node[i] = new ArrayList<>();
		}
		
		for (int i = 0; i <= max; i++) {
			if (i - 1 >= 0) {
				node[i].add(i - 1);
			}
			if (i + 1 <= max) {
				node[i].add(i + 1);
			}
			if (i * 2 <= max) {
				node[i].add(i * 2);
			}
		}
		
		distance = new int[max + 1];
		Arrays.fill(distance, -1);
		
		bfs(N);
		System.out.println(distance[K]);
	}
	private static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		
		distance[N] = 0;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			if (cur == K) {
				break;
			}
			
			for (int next : node[cur]) {
				if (distance[next] == -1) {
					queue.add(next);
					distance[next] = distance[cur] + 1;
				}
			}
		}
		
	}

}
