import java.util.*;
import java.io.*;

// a는 1보다 크거나 같고 100만 까지
// 서로 다름 -> 어떤 합이 되는 수
// 느낌상 투포인터인데 .. -> 왜 투포인터를 써야해? 뭐가 좋아서?
// 안쓰면 이중 for 문을 돌면서 합이 x인걸 찾아야하는데
// 100만이라 시간 N제곱이면 시간 초과나 갈까?

public class B3273 {

    static int n, x;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        x = Integer.parseInt(br.readLine());

        // 정렬하고 -> 더한게 크면 오른쪽을 줄이고 작으면 왼쪽을 옮기고
        Arrays.sort(arr);

        int left = 0;
        int right = n - 1;
        int count = 0;

        while (left < right) {

            int sum = arr[left] + arr[right];

            if (sum == x) {
                count++;
                left++;
                right--;
            } else if (sum > x) {
                right--;
            } else {
                left++;
            }
        }

        System.out.println(count);

    }
}
