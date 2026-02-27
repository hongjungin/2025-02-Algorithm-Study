import java.io.*;
import java.util.*;

public class B1158 {

    static int N, K;
    static Queue<Integer> people;

    public static void main (String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        people = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            people.add(i + 1);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        while (!people.isEmpty()) {

            for (int i = 0; i < K - 1; i++) {
                int a = people.poll();
                people.add(a);
            }

            int b = people.poll();

            if (people.isEmpty()) {
                sb.append(b);
            } else {
                sb.append(b).append(",").append(" ");
            }
        }

        sb.append(">");

    }
}
