import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, M;
    static int[] nums;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        nums = new int[M];
        visited = new boolean[N];

        perm(0);
    }


    static void perm(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(nums[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            nums[depth] = i + 1;
            perm(depth + 1);
            visited[i] = false;
            nums[depth] = 0;
        }
    }


}