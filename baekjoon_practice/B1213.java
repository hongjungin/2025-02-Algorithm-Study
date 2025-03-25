import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int[] alphabet = new int[26];

        for (int i = 0; i < input.length(); i++) {
            int num = input.charAt(i) - 'A';
            alphabet[num]++;
        }

        int oddCount = 0;
        int oddIndex = -1;

        for (int i = 0; i < 26; i++) {
            if (alphabet[i] % 2 != 0) {
                oddCount++;
                oddIndex = i;
            }
        }

        if (oddCount > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        StringBuilder sb = new StringBuilder();
        String center = "";

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < alphabet[i] / 2; j++) {
                sb.append((char)(i + 'A'));
            }
        }

        if (oddCount == 1) {
            center = String.valueOf((char)(oddIndex + 'A'));
        }

        StringBuilder answer = new StringBuilder();
        answer.append(sb);
        answer.append(center);
        answer.append(sb.reverse());

        System.out.println(answer);
    }
}