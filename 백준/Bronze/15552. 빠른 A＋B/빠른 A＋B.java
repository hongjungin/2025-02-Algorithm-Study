import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력용 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 출력용 StringBuilder
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int i = 0; i < T; i++) {
            // 공백 기준으로 자르기
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            sb.append(A + B).append('\n'); // 결과 누적
        }

        // 한 번에 출력
        System.out.print(sb);
    }
}
