
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Solution{
	static int T, N;
	static Map<Integer, Integer> map;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		for (int t = 1; t < T + 1; t++) {
			N = Integer.parseInt(br.readLine());
			map = new HashMap<>();
			int count = 0;
			while (N % 2 == 0) {
				count++;
				N /= 2;
			}
			map.put(2, count);
			
			for (int i = 3; i <= 11; i+=2) {
				if (i == 9) {
					continue;
				}
				count = 0;
				while (N % i == 0) {
					count++;
					N /= i;
				}
				map.put(i, count);
			}
			
			sb.append("#").append(t).append(" ");
			for (Integer v : map.values()) {
				sb.append(v).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
