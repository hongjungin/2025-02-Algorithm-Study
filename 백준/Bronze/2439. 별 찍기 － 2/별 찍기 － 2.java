import java.util.*;

public class Main {
	static int N;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N-1-i; j++) {
				System.out.print(" ");
			}
			for (int j = N-1-i; j < N; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}