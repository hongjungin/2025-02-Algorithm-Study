import java.io.*;
import java.util.*;

public class B11286 {

    static int N;
    static PriorityQueue<Integer> pq;

    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>((a, b) -> {
            int absA = Math.abs(a);
            int absB = Math.abs(b);

            if (absA == absB) {
                // 오름차순
                return Integer.compare(a, b);
            } else {
                return Integer.compare(absA, absB);
            }
        });

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());

            if (input == 0) {
                sb.append(pq.isEmpty() ? 0 : pq.poll()).append("\n");
            } else {
                pq.offer(input);
            }
        }

        System.out.println(sb);
    }
}
