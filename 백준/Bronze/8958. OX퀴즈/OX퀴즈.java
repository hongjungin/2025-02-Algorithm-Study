import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int T = Integer.parseInt(br.readLine());
         StringBuilder sb = new StringBuilder();
         for (int t = 0; t < T; t++) {
             String s = br.readLine();
             int score = 0, sum = 0;
             for (int i = 0; i < s.length(); i++) {
                 if (s.charAt(i) == 'O') {
                     score++;
                     sum += score;
                 } else {
                     score = 0;
                 }
             }
             sb.append(sum).append("\n");
         }
         System.out.print(sb);
    }
}
