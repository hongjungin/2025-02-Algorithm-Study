import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 지민이는 64cm 막대 가짐
// 가장 짧은거를 절반으로 잘라.

public class Main {
	static int X, count;
	static int bar = 64;
	static int sum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		X = Integer.parseInt(br.readLine());
		sum = 0;
		int count = 0;
		while (sum != X) {
			if (bar + sum > X) {
				bar /= 2;
			} else {
				sum += bar;
                count++;
			}
		}
		
		System.out.println(count);
	}


}
