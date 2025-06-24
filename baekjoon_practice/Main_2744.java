import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isUpperCase(c)) {
                char ch = Character.toLowerCase(c);
                sb.append(ch);
            } else {
                char ch = Character.toUpperCase(c);
                sb.append(ch);
            }
        }

        System.out.println(sb);
    }
}
