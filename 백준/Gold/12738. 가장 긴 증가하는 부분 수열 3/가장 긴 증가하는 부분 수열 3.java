import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int size;
	static int[] arr;
	static List<Integer> lis;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		size = Integer.parseInt(br.readLine());
		
		arr = new int[size];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < size; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		lis = new ArrayList<>();
		
		for (int i = 0; i < size; i++) {
			int idx = Collections.binarySearch(lis, arr[i]);
			if (idx < 0 ) {
				idx = -(idx + 1);
			}
			if (idx >= lis.size()) {
				lis.add(arr[i]);
			} else {
				lis.set(idx, arr[i]);
			}
		}
		
		System.out.println(lis.size());
	}
}
