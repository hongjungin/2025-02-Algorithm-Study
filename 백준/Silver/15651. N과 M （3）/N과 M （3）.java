import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] p;
    static int n, m;
    static int[] nums;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i + 1;
        }
        nums = new int[m];
        perm(0);
        System.out.println(sb.toString());
    }

    private static void perm(int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(nums[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            nums[depth] = p[i];
            perm(depth + 1);
            nums[depth] = 0;
        }
    }
}