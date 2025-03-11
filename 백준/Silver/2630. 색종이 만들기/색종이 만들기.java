import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 종이를 잘라서 정사각형 모양의 종이를 만들려고 함,
// 전체 종이가 모두 같은 색으로 칠해져 있지 않으면, -> 1/4 로 나눔
// 1 : 파란색 0 : 흰색

public class Main {
	static int N;
	static int blue, white;
	static int[][] paper;

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

		divide(0, 0, N);
		System.out.println(white);
		System.out.println(blue);
	}

	private static void divide(int row, int col, int size) {
		// 먼저 전체 탐색
		int color = paper[row][col];
		boolean isColorSame = true;
		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				if (color != paper[i][j]) {
					isColorSame = false;
					break;
				}
			}
			if (!isColorSame) {
				break;
			}
		}

		// 갯수 처리
		if (isColorSame) {
			if (color == 0) {
				white++;
			} else if (color == 1) {
				blue++;
			}
			return;
		}
		
		int newSize = size / 2;
		divide(row, col, newSize);
		divide(row, col + newSize, newSize);
		divide(row + newSize, col, newSize);
		divide(row + newSize, col + newSize, newSize);

	}

}
