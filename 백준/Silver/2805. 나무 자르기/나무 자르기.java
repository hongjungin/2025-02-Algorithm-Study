import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 나무 M미터 필요

public class Main {
    static int N, M, maxHeight;
    static int[] trees;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        trees = new int[N];
        maxHeight = Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            maxHeight = Math.max(maxHeight, trees[i]);
        }

        long result = BinarySearh();
        System.out.println(result);
    }
    private static int BinarySearh() {
        int start = 0;
        int end = maxHeight;
        int answer = 0;

        while (start <= end) {
            int mid = (start + end) / 2;
            long wood = getSum(mid);
            if (wood >= M) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return answer;
    }
    private static long getSum(int mid) {
        long sum = 0;
		for (int tree: trees) {
            if (tree >  mid) {
                sum += tree - mid;
            }
        }
        return sum;
    }


}