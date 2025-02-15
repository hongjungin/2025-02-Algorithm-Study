import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15650 {
    static int N;
    static int M;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[M];

        combi(0, 0);
    }

    private static void combi(int depth, int start) {
        // 기저조건
        if (depth == M) {
            for (int i = 0; i < N; i++) {
                System.out.print(nums[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < N; i++) {
            nums[depth] = i + 1;
            combi(depth + 1, i + 1);
            nums[depth] = 0;
        }
    }
}
