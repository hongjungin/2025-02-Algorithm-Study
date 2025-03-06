import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] times;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		times = new int[N];
		int totalTime = 0;
		int people = N;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			times[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(times);
		
		for (int i = 0; i < N; i++) {
			totalTime += times[i] * people;
			people--;
		}
		
		System.out.println(totalTime);
	}

}
