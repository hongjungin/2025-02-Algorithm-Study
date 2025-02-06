import java.util.Locale;
import java.util.Scanner;

class Main {
    public int solution(String str, char t){
        int answer = 0;
        str = str.toUpperCase();
        t = Character.toUpperCase(t);


        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        char c = kb.next().charAt(0);
        // 문자열 입력 받음.
        System.out.print(T.solution(str, c));
    }
}
//import java.util.Scanner;
//
//class Main2 {
//    public String solution(String str){
//        String answer = "";
//
//
//        return answer;
//    }
//
//    public static void main(String[] args) {
//        Main2 T = new Main2();
//        Scanner kb = new Scanner(System.in);
//        String str = kb.next();
//        System.out.println(T.solution(str));
//    }
//
//}