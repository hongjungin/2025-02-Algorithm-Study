import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 단어 두 개 중 앞부분이 제일 겹치는 단어..
// 단어 최대 2만대 -> 4억 시간초과 나올 수 있음 -> 정렬 하자 -> 이것도 안됨
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        int maxLen = -1;
        int idx1 = 0, idx2 = 1;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int len = 0;
                int minLen = Math.min(words[i].length(), words[j].length());
                for (int k = 0; k < minLen; k++) {
                    if (words[i].charAt(k) != words[j].charAt(k)) break;
                    len++;
                }

                if (len > maxLen) {
                    maxLen = len;
                    idx1 = i;
                    idx2 = j;
                }
            }
        }

        System.out.println(words[idx1]);
        System.out.println(words[idx2]);
    }
}
