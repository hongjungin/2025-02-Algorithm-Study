import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int N, K, length;
    static int[] count;
    static int[] S;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        S = new int[N];
        count = new int[100001];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int maxLength = 0;
        for (int end = 0; end < N; end++) {
            count[S[end]]++;

            while (count[S[end]] > K) {
                count[S[start]]--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        System.out.println(maxLength);
    }
}
