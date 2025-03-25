import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 5; i <= N; i *= 5) { // 5의 배수, 25의 배수, 125의 배수... 모두 카운트
            count += N / i;
        }

        System.out.println(count);
    }
}
