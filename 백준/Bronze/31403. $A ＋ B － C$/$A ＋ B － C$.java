import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // 수로 생각했을 때
    // 문자열로 생각했을 때
    static int A;
    static int B;
    static int C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = Integer.parseInt(br.readLine());
        B = Integer.parseInt(br.readLine());
        C = Integer.parseInt(br.readLine());
        String s = "" + A + B;
        int S = Integer.parseInt(s);

        System.out.println(A + B - C);
        System.out.println(S - C);
    }
}