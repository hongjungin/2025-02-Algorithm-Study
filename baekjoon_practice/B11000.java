import java.util.*;
import java.io.*;

public class B11000 {

    static int N;
    static int[][] time;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        time = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                time[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(time, Comparator.comparingInt(a -> a[0])); // 시작 순서대로 배열 정렬

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.offer(time[0][1]);

        for (int i = 1; i < N; i++) {
            if (!pq.isEmpty()) {
                int cur = pq.peek();

                if (cur > time[i][0]) {
                    pq.offer(time[i][1]);
                } else {
                    pq.poll();
                    pq.offer(time[i][1]);
                }
            }
        }

        System.out.println(pq.size());
    }
}
