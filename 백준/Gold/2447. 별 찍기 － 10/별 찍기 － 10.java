import java.util.*;

public class Main {
	static int N;
	static int board[][];

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		board = new int[N][N];
		star(0,0,N);

		print();
	}

	private static void star(int r, int c, int n) {
		if (n == 1) {
			board[r][c] = 1;
			return;
		}
		int m = n / 3;
		for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) { 
                    continue;
                }
                star(r + i * m, c + j * m, m);
            }
		}
		
	}

	private static void print() {
		StringBuilder sb = new StringBuilder();
		
		// 배열 안에 1 대신 * 삽입.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 1) {
					sb.append("*");
				} else {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}