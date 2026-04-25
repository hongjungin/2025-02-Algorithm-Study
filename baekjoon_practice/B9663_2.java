import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9663_2 {

    static int N;
    static int[] arr;
    static int count;

    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        count = 0;

        backTracking(0);

        System.out.println(count);
    }

    private static void backTracking(int depth) {

        // 1. 종료 조건 : 모든 행을 다 채우면? -> count 증가 후 리턴
        if (depth == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[depth] = i;

            if(isSafe(i)) {
                backTracking(depth + 1);
            }
        }

    }

    private static boolean isSafe (int depth) {

        for (int i = 0; i < depth; i++) {
            // 같은 열에 있나 체크
            if (arr[depth] == arr[i]) {
                return false;
            }

            // 대각선에 있나 체크
            if ((depth - i) == Math.abs(arr[depth] - arr[i])) {
                return false;
            }
        }

        return true;
    }
}
