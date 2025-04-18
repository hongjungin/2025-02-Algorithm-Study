import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// M X N 보드 -> 8 X 8로
// 검흰 번갈아서 칠해짐
// 
public class Main {
    static int N, M, minCount;
    static char[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        minCount = Integer.MAX_VALUE;
        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                int whiteCount = 0;
                int blackCount = 0;

                for (int x = i; x < i + 8; x++) {
                    for (int y = j; y < j + 8; y++) {
                        boolean isWhite = ((x + y) % 2 == 0);
                        if (isWhite) { // 짝수야 -> 시작이 W
                            if (board[x][y] != 'W') whiteCount++;
                            if (board[x][y] != 'B') blackCount++;
                        } else {
                            if (board[x][y] != 'B') whiteCount++;
                            if (board[x][y] != 'W') blackCount++;
                        }

                    }
                }
                //System.out.println("한번할 때 최소 :" + Math.min(whiteCount, blackCount));
                minCount = Math.min(Math.min(whiteCount, blackCount), minCount);
            }
        }
        System.out.println(minCount);
    }

}
