import java.util.*;
import java.io.*;

// 산성 -> 1부터 10억
// 알칼리성 -> -1부터 -10억
// 특성 값이 0이 되게? -> 더해서 0에 가장 가까운 애를 찾아
// 근데 둘 다 양수거나 둘아 음수일 수 있음

public class Main {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // sort NlogN 이라 sort 가능
        Arrays.sort(arr);

        // 투포인터 일 것 같긴한데 .... 이게 가장 가까운 ~ 이면 어떤 식으로 해여할까
        int left = 0;
        int right = N-1;
        long sum = 0L;
        long bestAbs = Long.MAX_VALUE;

        int a = 0;
        int b = 0;

        while (left < right) {

            sum = (long) arr[left] + arr[right];
            long cur = Math.abs(sum);

            if (cur < bestAbs) {
                // 이때 갱신이 들어가
                bestAbs = cur;
                a = arr[left];
                b = arr[right];
                if (cur == 0) break;
            }

            if (sum > 0) {
                right--;

            } else {
                left++;
            }

        }

        if (a > b) { int t = a; a = b; b = t; }
        System.out.println(a + " " + b);

    }
}
