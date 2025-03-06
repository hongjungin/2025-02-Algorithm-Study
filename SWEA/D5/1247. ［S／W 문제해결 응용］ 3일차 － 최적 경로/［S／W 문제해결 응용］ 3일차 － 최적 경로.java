import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// n명의 고객 -> 각 고객의 위치는 좌표로 주어짐
// n명의 고객 방문 경로 중 가장 짧은 것
// 회사 -> 고객 -> 집

class P {
	int x;
	int y;
	public P(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}

public class Solution {
	static int T, N;
	static int min;
	static boolean[] visited;
	static int[] nums;
	static List<P> people;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static P office, home;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			// 회사 좌표
			int cx = Integer.parseInt(st.nextToken());
			int cy = Integer.parseInt(st.nextToken());
			office = new P(cx, cy);
			
			// 집 좌표
			int hx = Integer.parseInt(st.nextToken());
			int hy = Integer.parseInt(st.nextToken());
			home = new P(hx, hy);
			
			people = new ArrayList<>();
			for (int j = 0; j < N; j++) {
				int px = Integer.parseInt(st.nextToken());
				int py = Integer.parseInt(st.nextToken());
				
				people.add(new P(px, py));
			}
			min = Integer.MAX_VALUE;
			visited = new boolean[N];
			nums = new int[N];
			perm(0);
			sb.append("#").append(t).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}
	private static void perm(int cnt) {
		if (cnt == N) {
			int sum = 0;
			sum += distance(office, people.get(nums[0]));
			for (int i = 0; i < N - 1; i++) {
				sum += distance(people.get(nums[i]), people.get(nums[i+1]));
				
			}
			sum += distance(people.get(nums[N-1]), home);
			min = Math.min(sum, min);
			return;
		}
		for (int i = 0; i < N; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			nums[cnt] = i;
			perm(cnt + 1);
			visited[i] = false;
		}
	}
	
	private static int distance(P p1, P p2) {
		return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
	}

}


