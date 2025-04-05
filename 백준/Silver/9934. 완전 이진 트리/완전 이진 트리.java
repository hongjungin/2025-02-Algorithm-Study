import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int K;
    static int[] tree;
    static List<List<Integer>> level;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());
        int size = (int) Math.pow(2, K) - 1;
        tree = new int[size];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }

        level = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            level.add(new ArrayList<>());
        }

        building(0, size - 1, 0);

        StringBuilder sb = new StringBuilder();
        for (List<Integer> lv : level) {
            for (int l : lv) {
                sb.append(l).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void building(int start, int end, int depth) {
        if (start > end) return;

        int mid = (start + end) / 2;
        level.get(depth).add(tree[mid]);

        building(start, mid - 1, depth + 1); // 왼
        building(mid + 1, end, depth + 1);   // 오른
    }
}
