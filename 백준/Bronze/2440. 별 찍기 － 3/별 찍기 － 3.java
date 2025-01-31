import java.util.*;

public class Main {
	static int N;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		scanner.close();
		
		for (int i = 0; i < N; i++) {
			for (int j = N; j > i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}