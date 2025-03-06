import java.util.Scanner;

class Main9 {
    public int solution(String str){
        String answer = "";
        for (char x : str.toCharArray()) {
            if(Character.isDigit(x)) answer += x;
        }
        return Integer.parseInt(answer);
    }

    public static void main(String[] args) {
        Main9 T = new Main9();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }

}