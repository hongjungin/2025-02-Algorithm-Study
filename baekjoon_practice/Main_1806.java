import java.util.*;
import java.io.*;

// 연속된 수들의 부분합 중 -> 그 합이 S 이상
// 근데 그 중에 가장 짧은 길이
// N은 10만 S는 1억
// 일단 정렬 아님
// 그리고 연속된 애들 합? -> 그럼 누적함을 갱신?
// 단조 증가 단조 감소가 아니니까 슬라이딩 투포인터로 풀 수 있음

public class Main_1806 {

    static int N, S;
    static int[] arr;

    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int cur = arr[0];
        int bestMin = Integer.MAX_VALUE;

        // 이게 그러면 종료 조건을 어떻게 둬여하지?
        while (true) {

            if (cur >= S) {
                bestMin = Math.min(bestMin, right-left+1);
                cur -= arr[left];
                left++;

            } else {
                right++;
                if (right == N) break;
                cur += arr[right];
            }
        }

        if (bestMin == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(bestMin);
        }
    }
}
