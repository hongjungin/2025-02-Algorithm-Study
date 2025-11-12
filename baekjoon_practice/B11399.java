import java.io.*;
import java.util.*;

// N 명의 사람 줄을 서
// 걸리는 시간 배열로 저장
// 누적되는 합이 제일 적게 ..

public class B11399 {

    static int N;
    static int[] P;

    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        P = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        // 이거 사실 그냥 정렬 때려서
        // 오름 차순 -> 누적합 하면 되는거 아닌가
        // 근데 만약에 그게 각각 백만이 넘어가면? 이땐 어떻게
        Arrays.sort(P);

        long answer = 0L;
        long running = 0L;

        for (int i = 0; i < N; i++) {
            if (i == 0) {
                running = P[0];
                answer = P[0];
            } else {
                running += P[i];
                answer += running;
            }
        }
        System.out.println(answer);
    }
}
