import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), ":");
		int m = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int totalTime = m * 60 + s;
		int count = 0;
		count += totalTime / 600;
		totalTime %= 600;
		count += totalTime / 60;
		totalTime %= 60;
		
		if (totalTime >= 30) {
			count++;
			totalTime -= 30;
			count += totalTime / 10;
		} else {
			count += totalTime / 10;
			count++;
			totalTime %= 10;
		}
		
		System.out.println(count);
	}

}
