import java.util.Scanner;

class Main24 {
    public String solution(String str){
        String answer = "";
        str = str.replaceAll("[^a-zA-Z]", "");
        System.out.println(str);
        String reverse = new StringBuilder(str).reverse().toString();
        System.out.println(reverse);
        if(str.equalsIgnoreCase(reverse)){
            answer = "YES";
            return answer;
        }
        answer = "NO";
        return answer;
    }
    public static void main(String[] args) {
        Main24 T = new Main24();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.println(T.solution(str));
    }

}
