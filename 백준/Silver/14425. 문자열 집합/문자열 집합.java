
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static Set<String> str;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		str = new HashSet<>();
		for (int i = 0; i < N; i++) {
			str.add(br.readLine());
		}
		int count = 0;
		for (int i = 0; i < M; i++) {
			if (str.contains(br.readLine())) {
				count++;
			}
		}
		System.out.println(count);
	}
}
