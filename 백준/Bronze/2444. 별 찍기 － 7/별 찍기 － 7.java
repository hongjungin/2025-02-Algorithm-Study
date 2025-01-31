import java.util.*;

public class Main {
	static int N;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		N = N*2 - 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < Math.abs(i - N/2); j++) {
				System.out.print(" ");
			}
			for (int k = 0; k < N-2*Math.abs(i - N/2); k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
