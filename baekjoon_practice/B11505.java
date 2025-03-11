import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11505 {
    static int N, M, K;
    static long[] arr;
    static long[] segTree;
    static int height, size;
    static long mul = 0L;
    static int index;
    static long value;
    static int left, right;
    static long k = 1_000_000_007L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        height = (int) Math.ceil(Math.log(N) / Math.log(2));
        size = 2 << height;
        segTree = new long[size];
        Arrays.fill(segTree, 1);
        init(1, 0, N - 1);

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if (a == 1){ // update
                index = Integer.parseInt(st.nextToken()) - 1;
                value = Long.parseLong(st.nextToken());
                update(1, 0, N-1);
            } else if (a == 2){ // get
                left = Integer.parseInt(st.nextToken()) - 1;
                right = Integer.parseInt(st.nextToken()) - 1;
                mul = 0L;
                mul = get(1, 0, N-1);
                System.out.println(mul);
            }
        }
    }
    private static long get(int node, int start, int end){
        if (left > end || right < start) {
            return 1;
        }
        if (left <= start && end <= right) {
            return segTree[node];
        } else {
            int mid = (start + end) / 2;
            long leftMul = get(node * 2, start, mid) % k;
            long rightMul = get(node * 2 + 1, mid + 1, end) % k;
            return (leftMul * rightMul) % k;
        }
    }

    private static void update(int node, int start, int end){
        if (start > index || end < index) return;
        if (start == end) {
            segTree[node] = value;
            return;
        } else {
            int mid = (start + end) / 2;
            update(node * 2, start, mid);
            update(node * 2 + 1, mid + 1, end);
            segTree[node] = (segTree[node * 2] * segTree[node*2 + 1]) % k;
        }
    }

    private static void init(int node, int start, int end){
        if (start == end) {
            segTree[node] = arr[start];
            return;
        } else {
            int mid = (start + end) / 2;
            init(node * 2, start, mid);
            init(node * 2 + 1, mid + 1, end);
            segTree[node] = (segTree[node * 2] * segTree[node*2 + 1]) % k;
        }
    }
}
