import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 김싸피 학번은 1
// 김싸피 동기의 수 N, 친구 정보의 길이 M
// 
public class Main {
	static int N, M;
	static List<Integer>[] graph;
	static boolean[] visited;
	static List<Integer> party;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[N + 1];
		for (int i = 0; i < N+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			graph[b].add(a);
		}
		
		visited = new boolean[N + 1];
		visited[1] = true;
		party = new ArrayList<>();
		
		startParty(1);
		for (int friend : graph[1]) {
			if (!visited[friend]) {
				visited[friend] = true;
				party.add(friend);
			}
		}
		
		int size = party.size();
		
		for (int i = 0; i < size; i++) {
			startParty(party.get(i));
		}
		
		size = party.size();
		System.out.println(size);
	}
	private static void startParty(int i) {
		for (int friend : graph[i]) {
			if (!visited[friend]) {
				visited[friend] = true;
				party.add(friend);
			}
		}
	
	}	

}
