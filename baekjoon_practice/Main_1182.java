import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1182 {
    static int N, S, count;
    static int[] arr;
    static boolean[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        selected = new boolean[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        count = 0;
        DFS(1);
        if(S==0) count--;
        System.out.println(count);
    }

    static void DFS(int depth) {
        if (depth == N + 1) {

            int sum = 0;
            for (int i = 1; i <= N; i++) {
                if(selected[i]) sum += arr[i - 1];
            }

            if(sum == S) count++;
        } else {
            selected[depth] = true;
            DFS(depth + 1);
            selected[depth] = false;
            DFS(depth + 1);
        }
    }
}
