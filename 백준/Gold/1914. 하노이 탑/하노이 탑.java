import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        BigInteger moves = BigInteger.valueOf(2).pow(N).subtract(BigInteger.ONE);
        System.out.println(moves);

        if (N <= 20) {
            hanoi(N, 1, 2, 3);
            System.out.print(sb);
        }

    }

    private static void hanoi(int n, int from, int via, int to) {
        if (n == 1){
            sb.append(from).append(" ").append(to).append("\n");
            return;
        }
        // n-1개의 원판을 from -> via로
        hanoi(n-1, from, to, via);
        // 가장 큰 원판을 from -> to호
        sb.append(from).append(" ").append(to).append("\n");
        // n-1개의 원판을 via -> to
        hanoi(n-1, via, from, to);


    }
}
