import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt(); // 첫 번째 숫자
        int B = sc.nextInt(); // 두 번째 숫자

        int B1 = B % 10;          // 일의 자리
        int B2 = (B / 10) % 10;   // 십의 자리
        int B3 = B / 100;         // 백의 자리

        System.out.println(A * B1);       // A × 일의 자리
        System.out.println(A * B2);       // A × 십의 자리
        System.out.println(A * B3);       // A × 백의 자리
        System.out.println(A * B);        // A × B 전체

        sc.close();
    }
}
