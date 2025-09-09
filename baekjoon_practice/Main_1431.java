import java.util.*;
import java.io.*;

import static java.lang.Character.isDigit;

// 기타를 빨리 찾아서 빨리 연주 해줘야 함
// 알파벳 + 숫자로 구성
// 길이가 다르면 짧은게 먼저 옴
// 길이가 같으면 숫자인것만 더해서 작은 합을 가지는 것이 먼저
// 1, 2로도 비교 불가면 사전순. 숫자가 알파벳보다 작음
public class Main_1431 {
    static int N;
    static List<String> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(br.readLine());
        }

        Collections.sort(list, (a,b) -> {
            if (a.length() != b.length()) return a.length() - b.length();
            else {
                int sumA = 0;
                for (char c : a.toCharArray()) {
                    if (isDigit(c)) {
                        sumA += c - '0';
                    }
                }
                int sumB = 0;
                for (char c : b.toCharArray()) {
                    if (isDigit(c)) {
                        sumB += c - '0';
                    }
                }
                int result = sumA - sumB;
                if (result == 0) return a.compareTo(b);
                else return sumA - sumB;
            }
        });


        for (String s : list) {
            System.out.println(s);
        }

    }
}
