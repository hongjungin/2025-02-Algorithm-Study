import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        int A = Integer.parseInt(tokens[0]);
        int B = Integer.parseInt(tokens[1]);
        System.out.println(A * B);
    }
}
