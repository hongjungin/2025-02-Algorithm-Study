import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 1; // 시작 방 (중심 방은 1번)
        int range = 1; // 현재 층까지 포함한 방의 개수 범위

        // N이 범위를 넘을 때까지 층 수를 늘려감
        while(range < N) {
            range += count * 6;
            count++;
        }
        System.out.println(count);
    }
}
