import java.util.*;
import java.io.*;

// 모든 수는 자신의 한 칸 위에 있는 수보다 큼
// 이럴 때 N번째 큰 수를 구하라

public class B2075 {

    static int N;
    static int[][] map;

    public static void main (String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int input = Integer.parseInt(st.nextToken());
                pq.offer(input);
                if (pq.size() > N) {
                    pq.poll();
                }
            }
        }

        System.out.println(pq.poll());

    }
}
