import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int N;
	
	static class node implements Comparable<node> {
		int x;
		int y;
		
		node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int compareTo(node o) {
			if (this.y == o.y) {
				return this.x - o.x;
			}
			return this.y - o.y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		node[] arr = new node[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[i] = new node(a, b);
		}
		
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		for (node a : arr) {
			sb.append(a.x).append(" ").append(a.y).append("\n");
		}
		
		System.out.println(sb);
	}

}
