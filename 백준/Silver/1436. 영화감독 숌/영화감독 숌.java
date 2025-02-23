import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        count = 0;
        int num = 666;
        int answer = 0;

        while (count < N) {
            String str = String.valueOf(num);
            if (str.contains("666")) {
                count++;
                answer = Integer.parseInt(str);
            }
            num++;
        }

        if (count == N) {
            System.out.println(answer);
        }
    }
}