import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, W, L;
    static int[] progress, weights;
    static int weight, count, answer, next, index, n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        n = N;
        W = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        progress = new int[W];
        index = 0;
        weights = new int[N];
        weight = 0;
        count = 0;
        answer = 0;
        next = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }

        while (n > 0) {
            int endWeight = progress[index];

            if (endWeight > 0) {
                count--;
                n--;
            }
            weight -= endWeight;
            if (next < N && weight + weights[next] <= L && count < W) {
                progress[index] = weights[next];
                count++;
                weight += weights[next];
                next++;
            } else {
                progress[index] = 0;
            }
            answer++;
            index = (index + 1) % W;
        }
        System.out.println(answer);
    }
}