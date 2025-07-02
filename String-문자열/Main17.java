import java.util.Locale;
import java.util.Scanner;

class Main17 {
    public int solution(String str, char t){
        String input = str.toLowerCase();
        t = Character.toLowerCase(t);
        int answer = 0;

        for (char c : input.toCharArray()) {
            if (c == t) {
                answer++;
            } else {
                continue;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main17 T = new Main17();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        char t = kb.next().charAt(0);
        System.out.println(T.solution(str, t));
    }

}