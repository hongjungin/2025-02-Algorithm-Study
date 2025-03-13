import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 스크린은 N칸으로 나누어짐
// 스크린 아래에는 M칸을 차지하는 바구니가 있음.
// J 는 사괴의 개수
// 그 다음은 사과가 떨어지는 위치
public class Main {
    static int N, M, J;
    static int[] apple;
    static int start, end, move;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        J = Integer.parseInt(br.readLine());
        apple = new int[J];
        for (int i = 0; i < J; i++) {
            apple[i] = Integer.parseInt(br.readLine());
        }

        start = 0;
        end = M;

        int move = 0;

        for (int i = 0; i < J; i++) {
            int a = apple[i] - 1;
            if (a >= start && a < end) {
                continue;
            } else if (a >= end) {
                if (a + 1 > N) {
                    int temp = N - end;
                    end = N;
                    start = end - M;
                    move += temp;
                } else {
                    int temp = (a + 1) - end;
                    end = a + 1;
                    start = end - M;
                    move += temp;
                }
            } else if (a < start) {
                int temp = start - a;
                start = a;
                end = start + M;
                move += temp;
            }
        }

        System.out.println(move);
    }
}
