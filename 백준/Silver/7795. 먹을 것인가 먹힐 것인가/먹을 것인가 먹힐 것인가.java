import java.util.*;
import java.io.*;

public class Main {
    static int T, N, M, count;
    static int[] A, B;

    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

//            System.out.println("N :" + N + " M :" + M);
            A = new int[N];
            B = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(A);

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(B);

            count = 0;
            int i = 0;
            int j = 0;

            while (i < N && j < M) {
                if (A[i] <= B[j]) {
                    count += j;
                    i++;
                } else {
                    j++;
                }
            }
            
            while (i < N) {
                count += j;
                i++;
            }

//            System.out.println(t + " : " + count);
            sb.append(count).append("\n");

        }
        System.out.println(sb);

    }
}
