import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int n, m;
    static int[] arr, num;
    static boolean[] visited;
    static StringBuffer sb = new StringBuffer(); 

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        n = Integer.parseInt(firstLine[0]);
        m = Integer.parseInt(firstLine[1]);

        String[] secondLine = br.readLine().split(" ");
        num = new int[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(secondLine[i]);
        }

        Arrays.sort(num);
        arr = new int[m];

        func(0);
        System.out.print(sb.toString());
    }

    private static void func(int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = num[i];
                func(depth + 1);
                visited[i] = false;
            }
        }
    }
}