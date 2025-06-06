import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(br.readLine());
			if (a != 0) {
				pq.add(a);
			} else if (a == 0) {
				if (pq.isEmpty()) {
					sb.append(a).append("\n");
				} else {
					int temp = pq.poll();
					sb.append(temp).append("\n");
				}
			}
		}
		System.out.println(sb);
	}

}
