import java.util.*;

public class Main {
	static int[][] star;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		if (N == 1) {
			System.out.println("*");
			return;
		}

		star = new int[4 * N - 1][4 * N - 3];
		StringBuilder sb = new StringBuilder();

		function(1);
		listToString(sb);

		System.out.print(sb.toString());
	}

	public static void function(int n) {
		int r = n * 2 - 2;
		int num = 4 * N - 3 - r * 2;
		if (n == N) {
			star[2 * n - 2][2 * n - 2] = 1;
			star[2 * n - 2][2 * n - 1] = 1;
			star[2 * n - 1][2 * n - 2] = 1;
			star[2 * n][2 * n - 2] = 1;
		} else {
			for (int i = 0; i < num; i++) {
				star[r][r + i] = 1;
				star[r + num + 1][r + i] = 1;
			}
			for (int i = 0; i < num + 2; i++) {
				star[r + i][r] = 1;
				star[r + i][r + num - 1] = 1;
			}
			star[r + 2][r + num - 2] = 1;
			star[r + 1][r + num - 1] = 0;
			function(n + 1);
		}
	}

	public static void listToString(StringBuilder sb) {
		for (int i = 0; i < star.length; i++) {
			for (int j = 0; j < star[i].length; j++) {
				if (star[i][j] == 1) {
					sb.append("*");
				} else if (i == 1) {
					break;
				} else {
					sb.append(" ");
				}
			}
			if (i < star.length - 1) {
				sb.append("\n");
			}
		}
	}
}
