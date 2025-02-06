import java.util.Scanner;

class Main2 {
    public String solution(String str){
        String answer = "";
        for (char x : str.toCharArray()) {
            if (Character.isLowerCase(x)) answer+= Character.toUpperCase(x);
            else answer += Character.toLowerCase(x);
        }

        return answer;
    }

    public static void main(String[] args) {
        Main2 T = new Main2();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
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