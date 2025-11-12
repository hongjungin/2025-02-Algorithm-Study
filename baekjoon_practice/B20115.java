import java.util.*;
import java.io.*;

// 가장 큰 애 말고 다 2로 나눠
public class B20115 {
    static int[] drinks;
    static double total;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        drinks = new int[N];

        for (int i = 0; i < N; i++) {
            drinks[i] = Integer.parseInt(st.nextToken());
        }

        total = 0;

        Arrays.sort(drinks);

        for (int i = 0; i < N - 1; i++) {
            total += (double)drinks[i] / 2;
        }

        total += drinks[N - 1];

        if (total == Math.floor(total)) {
            System.out.println((int)total);
        } else {
            System.out.println(total);
        }


    }

}
