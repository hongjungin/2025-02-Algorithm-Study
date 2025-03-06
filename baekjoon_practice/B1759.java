import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 오름차순
public class B1759 {
    static  int L, C;
    static char[] input;
    static char[] code;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        input = new char[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            input[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(input);
        code = new char[L];

        perm(0,0);
        System.out.print(sb);
    }

    static void perm(int start, int depth) {
        if (depth == L) {
            int vowels = 0, cons = 0;
            for (int i = 0; i < L; i++) {
                char c = code[i];
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    vowels++;
                } else {
                    cons++;
                }
            }
            if (vowels >= 1 && cons >= 2) {
                sb.append(new String(code)).append("\n");
            }
            return;
        }

        for (int i = start; i < C; i++) {
            code[depth] = input[i];
            perm(i+1, depth+1);

        }
    }
}

