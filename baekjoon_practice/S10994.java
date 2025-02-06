import java.util.Scanner;

public class S10994 {
    // 1->1 2->5 3->9 4->13 => 차이가 4씩 나니까 4n으로 시작.(등차수열) 그리고 첫번째 항에 맞춰서 뒤에 구함. 4n-3
    // 전체 패턴은 (4N-3)(4N-3) 크기의 2차원 배열
    // 바깥쪽 테두리를 *로 채우고 내부가 재귀,,

    // 코드 작성 순서
    // 배열 정의
    // 재귀함수 작성

    // 1. 배열 정의
    static int[][] array; // 숫자 배열로 생성
    static int size; // 배열 크기

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        size = 4 * n - 3;
        array = new int[size][size];

        setArrays(n,0);
        print();
    }

    private static void setArrays(int n, int start) {
        // 종료 조건
        // 종료 조건을 n이 0일 때로 잡은 이유 -> n = 1 일 때 가운데 * 하나 그림
        // 0일 때는 아무것도 그리지 않아서 적합하다고 생각.
        if (n == 0) return;

        int end = size - start - 1;

        //  위 아래 테두리 채우기
        for (int i = start; i <= end; i++) {
            array[start][i] = n;
            array[end][i] = n;
        }

        // 좌우 테두리 채우기
        for (int i = start; i <= end; i++) {
            array[i][start] = n;
            array[i][end] = n;
        }

        // 재귀 호출
        setArrays(n - 1, start + 2);
    }

    public static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (array[i][j] > 0) {
                    sb.append('*');
                } else {
                    sb.append(' ');
                }
            }
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }
}
