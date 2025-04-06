import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 입력 숫자
        int F = sc.nextInt(); // 나눌 값

        int base = (N / 100) * 100; // 뒷자리를 00으로 만든 수

        int result = 0;
        for (int i = 0; i < 100; i++) {
            if ((base + i) % F == 0) {
                result = i;
                break;
            }
        }

        // 두 자리 수로 출력 (한 자리일 경우 앞에 0 붙임)
        System.out.printf("%02d", result);
        sc.close();
    }
}
