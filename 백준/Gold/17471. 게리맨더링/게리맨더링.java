import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// N 개의 구역
// 구역을 2개의 선거구로 나눠야 함 -> 각 구역은 두 선거구 중 하나에 포함되어야 한다.
// 두 구역의 인구 차이 최소
// 2 선거구로 나눌 수 없을 때 -1 출력

public class Main {
	static int N, minDiff;
	static int[] population;
	static List<Integer>[] graph;
	static boolean[] selected;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		population = new int[N+1];
		
		for (int i = 1; i < N + 1; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}
		
		graph = new ArrayList[N + 1];
		
		for (int i = 0; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for (int j = 0; j < num; j++) {
				int a = Integer.parseInt(st.nextToken());
				
				graph[i].add(a);
			}
		}
		minDiff = Integer.MAX_VALUE;
		selected = new boolean[N + 1];
		subset(0);
		
		System.out.println(minDiff == Integer.MAX_VALUE ? -1 : minDiff);
	}
	private static void subset(int depth) {
		if (depth == N) {
			List<Integer> groupA = new ArrayList<>();
			List<Integer> groupB = new ArrayList<>();
			
			for (int i = 1; i < N + 1; i++) {
				if (selected[i]) groupA.add(i); 
				else groupB.add(i);
			}
			
			// 그룹이 비어있으면 종료
			if (groupA.isEmpty() || groupB.isEmpty()) {
				return;
			}
			// 그룹이 이어져있지 않으면 종료
			if (isConnected(groupA) && isConnected(groupB)) {
				int sumA = 0; int sumB = 0;
				for (int a : groupA) {
					sumA += population[a];
				}
				for (int b : groupB) {
					sumB += population[b];
				}
				minDiff = Math.min(minDiff, Math.abs(sumA - sumB));
			}
			
			return;
		}
		
		selected[depth] = true;
		subset(depth + 1);
		selected[depth] = false;
		subset(depth + 1);
		
	}
	private static boolean isConnected(List<Integer> group) {
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[N + 1];
		queue.offer(group.get(0));
	
		
		while (!queue.isEmpty()) {
			int current = queue.poll();
			visited[current] = true;
			
			for (int a : graph[current]) {
				if (group.contains(a) && !visited[a]) {
					visited[a] = true;
					queue.offer(a);
				}
			}
		}
		int count = 0;
		for (int i = 0; i < group.size(); i++) {
			if (visited[group.get(i)]) {
				count++;
			}
		}
		
		if (count == group.size()) {
			return true;
		}
		return false;
	}

}
