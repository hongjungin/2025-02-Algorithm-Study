
// N개의 로프
// k개의 로프를 사용해 중량이 w인 물체를 들어올림

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2217 {
    static int N;
    static int[] rope;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        rope = new int[N];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            rope[i] = Integer.parseInt(br.readLine());
            min = Math.min(min, rope[i]);
        }

        System.out.println(min * N);
    }
}
