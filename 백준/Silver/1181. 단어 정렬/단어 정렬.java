import java.io.*;
import java.util.*;
// 단어 N개 (2만개)
// 길이가 짧은 것 부터 + 길이가 같으면 -> 사전 순
// 중복되는 건 제거
// 어떤 자료형에 단어를 담을 것인가 ? -> 중복 제거 hashmap? 그래서 정렬 2번
public class Main {
    static int N;
    static TreeSet<String> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        set = new TreeSet<>(
                (a,b) -> {
                    if (a.length() != b.length()) return a.length() - b.length();
                    return a.compareTo(b);
                }
        );
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        for (String s : set) {
            System.out.println(s);
        }

    }
}
