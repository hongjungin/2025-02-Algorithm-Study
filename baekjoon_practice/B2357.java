import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2357 {
    static class Seg{
        static class Node{
            long min, max;
            Node(long min,long max) {
                this.min = min;
                this.max = max;
            }
        }

        int size, left, right;
        long[] arr;
        Node[] tree;

        Seg(int n) {
            size = n;
            int height = (int) Math.ceil(Math.log(n) / Math.log(2));
            int segSize = 2 << height;
            arr = new long[n];
            tree = new Node[segSize];
        }

        void init(int node, int start, int end) {
            if (start == end) {
                tree[node] = new Node(arr[start], arr[start]);
                return;
            } else {
                int mid = (start + end) / 2;
                init(node * 2, start, mid);
                init(node * 2 + 1, mid + 1, end);
                tree[node] = new Node(Math.min(tree[node * 2].min, tree[node * 2 + 1].min), Math.max(tree[node * 2].max, tree[node * 2 + 1].max));
            }
        }

        Node get(int node, int start, int end, int left, int right) {
            if (left > end || right < start) {
                return new Node(Long.MAX_VALUE, Long.MIN_VALUE); // 여기 수정 필요
            }
            if (left <= start && end <= right) {
                return tree[node];
            } else {
                int mid = (start + end) / 2;
                Node lVal = get(node * 2, start, mid, left, right);
                Node rVal = get(node * 2 + 1, mid + 1, end, left, right);
                return new Node(Math.min(lVal.min, rVal.min), Math.max(lVal.max, rVal.max));
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Seg seg = new Seg(N);
        for (int i = 0; i < N; i++) {
            seg.arr[i] = Long.parseLong(br.readLine());
        }

        seg.init(1, 0, N-1);

        for (int i = 0; i < M; i++) {
            StringBuilder sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            Seg.Node result = seg.get(1, 0, N-1, a, b);
            sb.append(result.min).append(" ").append(result.max);
            System.out.println(sb);
        }

    }
}
