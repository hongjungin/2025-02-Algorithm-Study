import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int count = N / 4;  // 4바이트당 long 1개

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append("long ");
        }
        sb.append("int");

        System.out.println(sb.toString());
    }
}
