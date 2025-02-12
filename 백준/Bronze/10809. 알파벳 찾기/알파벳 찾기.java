import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        int[] index = new int[26];
        // 없으면 -1 로 저장하기 때문에 -1 값으로 초기화.
        Arrays.fill(index, -1);

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            int charIndex = c - 'a';

            if (index[charIndex] == -1) {
                index[charIndex] = i;
            }
        }

        // 출력
        for (int i = 0; i < index.length; i++) {
            System.out.print(index[i] + " ");
        }

        sc.close();
    }
}
