import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());

        int bitSet = 0; // 비트마스킹으로 집합 표현

        while (M-- > 0) {
            String[] input = br.readLine().split(" ");
            String cmd = input[0];

            if (cmd.equals("add")) {
                int x = Integer.parseInt(input[1]);
                bitSet |= (1 << (x - 1)); // x 번째 비트를 1로 설정
            } else if (cmd.equals("remove")) {
                int x = Integer.parseInt(input[1]);
                bitSet &= ~(1 << (x - 1)); // x 번째 비트를 0으로 설정
            } else if (cmd.equals("check")) {
                int x = Integer.parseInt(input[1]);
                sb.append(((bitSet & (1 << (x - 1))) != 0 ? 1 : 0)).append("\n");
            } else if (cmd.equals("toggle")) {
                int x = Integer.parseInt(input[1]);
                bitSet ^= (1 << (x - 1)); // x 번째 비트를 반전 (0 → 1, 1 → 0)
            } else if (cmd.equals("all")) {
                bitSet = (1 << 20) - 1; // 11111111111111111111 (1~20까지 모두 포함)
            } else if (cmd.equals("empty")) {
                bitSet = 0; // 00000000000000000000 (빈 집합)
            }
        }

        System.out.print(sb);
    }
}
