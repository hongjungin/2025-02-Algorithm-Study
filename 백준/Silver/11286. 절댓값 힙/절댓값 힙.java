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

		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
			if(Math.abs(o1) == Math.abs(o2)) return Integer.compare(o1, o2);
			return Integer.compare(Math.abs(o1), Math.abs(o2));
		});
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(br.readLine());
			if (a != 0) {
				pq.add(a);
			} else {
				if (pq.isEmpty()) {
					sb.append("0\n");
				} else {
					sb.append(pq.poll()).append("\n");
				}
			}
		}
		System.out.println(sb);
	}

}
