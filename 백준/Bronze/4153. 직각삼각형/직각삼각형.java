import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int[] sides = new int[3];

            for (int i = 0; i < 3; i++) {
                sides[i] = sc.nextInt();
            }

            // 종료 조건
            if (sides[0] == 0 && sides[1] == 0 && sides[2] == 0) {
                break;
            }

            // 정렬하여 가장 긴 변을 마지막 요소로 설정
            Arrays.sort(sides);

            // 피타고라스 정리 확인
            if (sides[0] * sides[0] + sides[1] * sides[1] == sides[2] * sides[2]) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }

        sc.close();
    }
}
