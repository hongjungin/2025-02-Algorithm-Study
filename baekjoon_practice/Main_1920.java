import java.util.*;
import java.io.*;

public class Main_1920 {
    static int N, M;
    static int[] A;
    static int[] input;
    public static void main (String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());

        input = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }


        Arrays.sort(A);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            sb.append(binarySearch(A, input[i])).append("\n");
        }

        System.out.println(sb.toString());

    }

    static int binarySearch(int[] A, int target) {
        int left = 0;
        int right = N-1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int val = A[mid];

            if (val == target) {
                return 1;
            } else if (val < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 0;
    }
}
