import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10597 {
    static int N;
    static String input;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        visited = new boolean[51];

        subset(0,0);
    }

    private static void subset(int depth, int start) {
        if (depth == N) {
            return;
        }
        // 전부 다 한 자리
        // 2자리 수가 섞이면 1~9갯수 빼고 나누기 2하면 2자리인 개수 나옴.
        if (input.length() < 9){

        }

    }
}
