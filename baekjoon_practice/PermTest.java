public class PermTest {
    static int[] p = {1, 2, 3, 4, 5};
    static int N, R, count;
    static int[] nums;
    static boolean[] visited;

    public static void main(String[] args) {
        N = p.length;
        R = 3;
        count = 0;
        nums = new int[R];
        visited = new boolean[N];

        perm(0);

    }

    private static void perm(int depth) {
        if (R == depth) {
            // R개를 모두 선택했으니 출력
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            nums[depth] = p[i];
            perm(depth + 1);
            visited[i] = false;
            nums[depth] = 0;
        }
    }
}
