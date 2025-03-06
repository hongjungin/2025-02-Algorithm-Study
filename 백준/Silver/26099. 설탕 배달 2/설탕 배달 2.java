import java.io.BufferedReader;
import java.util.Scanner;

public class Main {
	static long N;
	static int[] rule = {1, 2, 3, 2, 3};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextLong();
		
		long count = 0;
		if (N == 4 || N == 7) {
			count = - 1;
		} else if (N == 3 || N == 5) {
			count = 1;
		} else {
			long index = N % 5;
			long a = N / 5;
			count = rule[(int) index] + (a - 1);
		}
		
		System.out.println(count);
	}

}
