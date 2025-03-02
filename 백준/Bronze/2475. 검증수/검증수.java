import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         String[] tokens = br.readLine().split(" ");
         int sum = 0;
         for (String t : tokens) {
             int num = Integer.parseInt(t);
             sum += num * num;
         }
         System.out.println(sum % 10);
    }
}
