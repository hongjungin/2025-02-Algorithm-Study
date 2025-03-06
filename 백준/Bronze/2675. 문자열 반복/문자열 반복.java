import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            String[] parts = br.readLine().split(" ");
            int R = Integer.parseInt(parts[0]);
            String S = parts[1];
            for (int i = 0; i < S.length(); i++) {
                char c = S.charAt(i);
                for (int j = 0; j < R; j++) {
                    sb.append(c);
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
