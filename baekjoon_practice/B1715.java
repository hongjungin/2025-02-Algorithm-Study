import java.io.*;
import java.util.*;

// N이 10만 임 -> 정렬 + 재정렬 하면 터져
// 이럴때는 pq 사용하는게 좋음
// 1초에 1억번 연산 가능

public class B1715 {

    static int N, count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        count = 0;

        if (N == 1) {
            System.out.println(0);
            return;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int c = Integer.parseInt(br.readLine());
            pq.offer(c);
        }

        int sum = 0;

        while (!pq.isEmpty()) {
            int first = pq.poll();
            int second = pq.poll();
//            System.out.println("first : " + first + " second : " + second);

            count = first + second;
//            System.out.println("count : " + count);
            sum += count;
//            System.out.println("sum : " + sum);
            pq.offer(count);

            if (pq.size() == 1) {
                System.out.println(sum);
                return;
            }
        }


    }
}
