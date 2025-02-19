import java.util.Scanner;

public class B2231 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = 0;
        // N + N의 자릿수 만큼 각 자리수 더해
        for (int i = 1; i < N; i++) {
            // M이 num이라면
            int num = i;
            int temp = i;

            while (temp > 0) {
                num += temp % 10;
                temp /= 10;
            }
            if (num == N){
                M = i;
                break;
            }
        }
        System.out.println(M);
    }
}
