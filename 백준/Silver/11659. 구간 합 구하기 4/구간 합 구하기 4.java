// i 번째 부터 j 번째 수까지 합을 구하는 프로그램을 작성하시오

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] prefix;
    static int start,end;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        prefix = new int[N + 1];
        prefix[0] = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            prefix[i] = prefix[i - 1] + num;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            int result = prefix[end] - prefix[start - 1];
            
            System.out.println(result);
        }
    }
}
