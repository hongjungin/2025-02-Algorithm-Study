import java.util.Scanner;

public class Main {
    static int N;
    static int R;
    static int[] nums;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        R = N;
        nums = new int[N];
        visited = new boolean[N];

        perm(0);
    }

    static void perm(int depth) {
        if (R == depth) {
            for (int i = 0; i < N; i++) {
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
