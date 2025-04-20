import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static class Trie {
        Trie[] child = new Trie[10];
        boolean isEnd;
    }

    static boolean insert(Trie root, String number) {
        Trie current = root;
        for (int i = 0; i < number.length(); i++) {
            int index = number.charAt(i) - '0';

            if (current.child[index] == null) {
                current.child[index] = new Trie();
            }

            current = current.child[index];
            if (current.isEnd) {
                return false;
            }
        }

        for (Trie c : current.child) {
            if (c != null) {
                return false;
            }
        }
        current.isEnd = true;
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0){
            int n = Integer.parseInt(br.readLine());
            String[] numbers = new String[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = br.readLine();
            }

            Arrays.sort(numbers);
            Trie root = new Trie();
            boolean isConsistent = true;

            for (String num : numbers) {
                if (!insert(root, num)) {
                    isConsistent = false;
                    break;
                }
            }
            if (isConsistent) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }
}
