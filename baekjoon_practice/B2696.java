import java.util.*;
import java.io.*;

public class B2696 {

    static int T, N, middle;

    public static void main (String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            middle = N/2 + 1;
            sb.append(middle).append("\n");

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {

            }
        }
    }
}
