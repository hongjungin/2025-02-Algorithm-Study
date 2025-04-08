import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static List<int[]> elec;
	static List<Integer> lis; 
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		elec = new ArrayList<>();
		lis = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			elec.add(new int[] {idx, v});
		}
		
		elec.sort(Comparator.comparingInt(s -> s[0]));
		
		Collections.fill(lis, 1);
		
		for (int i = 0; i < elec.size(); i++) {
			int index = Collections.binarySearch(lis, elec.get(i)[1]);
			if (index < 0) {
				index = -(index + 1);
			}
			if (index >= lis.size()) {
				lis.add(elec.get(i)[1]);
			} else {
				lis.set(index, elec.get(i)[1]);
			}
		}
		
		int size = lis.size();
		int result = N - size;
		System.out.println(result);
	}

}
