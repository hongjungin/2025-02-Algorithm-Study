import java.util.Scanner;

class Main8 {
    public String solution(String s){
        String answer = "NO";
        // A - Z까지가 아니면
        s = s.toUpperCase().replaceAll("[^A-Z]", "");
        String tmp = new StringBuilder(s).reverse().toString();
        if (s.equals(tmp)) answer = "YES";

        return answer;
    }

    public static void main(String[] args) {
        Main8 T = new Main8();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.println(T.solution(str));
    }

}