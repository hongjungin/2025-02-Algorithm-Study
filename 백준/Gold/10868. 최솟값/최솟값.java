import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	static int N, M;
	static long[] arr;
	static int left, right, size, height;
	static long[] segTree;
	static long minResult; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new long[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		height = (int) Math.ceil(Math.log(N) / Math.log(2));
		size = 2 << height;
		
		segTree = new long[size];
		init(1, 0, N-1);
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			left = Integer.parseInt(st.nextToken()) - 1;
			right = Integer.parseInt(st.nextToken()) - 1;
			minResult = 0L;
			minResult = get(1, 0, N-1);
			System.out.println(minResult);
		}
	}
	private static long get(int node, int start, int end) {
		if (left > end || right < start) {
			return Long.MAX_VALUE; 
			// 범위 x
 		}
		if (left <= start && end <= right) {
			return segTree[node];
		} else {
			int mid = (start + end) / 2;
			long leftMin = get(node * 2, start, mid);
			long rightMin = get(node * 2 + 1, mid + 1, end);
			return Math.min(leftMin, rightMin);
		}
	}
	private static void init(int node, int start, int end) {
		if (start == end) {
			segTree[node] = arr[start];
			return;
		} else {
			int mid = (start + end) / 2;
			init(node * 2, start, mid);
			init(node * 2 + 1, mid + 1, end);
			segTree[node] = Math.min(segTree[node * 2], segTree[node * 2 + 1]);
		}
		
	}

}
