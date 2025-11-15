import java.util.*;
import java.io.*;

public class Main_12015 {

    static int N;
    static int[] arr;
    static List<Integer> lis;

    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        lis = new ArrayList<>();
        lis.add(arr[0]);

        for (int i = 1; i < N; i++) {

            if (arr[i] > lis.get(lis.size()-1)) {
                lis.add(arr[i]);
            } else {

                int pos = Collections.binarySearch(lis, arr[i]);

                if (pos < 0) pos = - pos - 1;
                lis.set(pos, arr[i]);

            }
        }

        System.out.println(lis.size());


    }
}
