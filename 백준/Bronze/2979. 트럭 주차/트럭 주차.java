import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 트럭 총 3개
    // 시작 ~ 끝 기록 -> 어떤 자료 구조 써야함?
    // 이걸 시작과 끝을 어떻게 관리해야함?.... 너무 어려운데
    //
    static int A, B, C;
    static int[] time;
    static int sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        sum = 0;
        time = new int[101];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            for (int j = start; j < end; j++) {
                time[j]++;
            }
        }


        for (int i = 0; i < time.length; i++) {
            if (time[i] == 1) {
                sum += A;
            } else if (time[i] == 2) {
                sum += B * 2;
            } else if (time[i] == 3) {
                sum += C * 3;
            }
        }
        System.out.println(sum);
    }

}
