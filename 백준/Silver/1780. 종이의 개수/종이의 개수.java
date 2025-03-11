import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] paper;
	static int a, b, c; // a : - 1 b : 0 c : 1
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		paper = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		a = 0;
		b = 0;
		c = 0;
		cut(0, 0, N);
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}

	private static void cut(int row, int col, int size) {
		int start = paper[row][col];
		boolean isSame = true;
		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				if (paper[i][j] != start) {
					isSame = false;
					break;
				}
			}
			if (!isSame) {
				break;
			}
		}
		
		
		if (isSame) {
			if (start == - 1) {
				a++;
			} else if (start == 0) {
				b++;
			} else if (start == 1) {
				c++;
			}
		} else {
			int newSize = size / 3;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					cut(row + newSize * i, col + newSize * j, newSize);
				}
			}
		
		}
	}

}
