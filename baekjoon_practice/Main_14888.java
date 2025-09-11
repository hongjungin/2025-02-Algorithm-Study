import java.util.*;
import java.io.*;
import java.lang.*;

// 수는 위치 고정.
// 연산자가 순열 조합 -> 연산자를 배치하고 그 다음에 연산하고 그다음에 최대최소?

public class Main_14888 {

    static int N;
    static int[] arr;
    static int[] operator; // + - * /
    static int[] selected;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main (String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        operator = new int[4];
        selected = new int[N-1];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        // 이제 배치
        dfs(0, arr[0]);
        System.out.println(max);
        System.out.println(min);
    }

    static void dfs (int depth, int next) {

        if (depth == N - 1) {
            min = Math.min(min, next);
            max = Math.max(max, next);
            return;
        }

        int val = 0;

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;
                val = cal(next, arr[depth + 1], i);
                dfs(depth + 1, val);
                operator[i]++;
            }
        }
    }

    private static int cal(int cur, int next, int operator) {

        if (operator == 0) {
            return cur + next;

        } else if (operator == 1) {
            return cur - next;
        } else if (operator == 2) {
            return cur * next;
        } else if (operator == 3) {
            return cur / next;
        }
        return 0;
    }
}
