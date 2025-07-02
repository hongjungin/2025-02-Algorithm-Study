import java.util.Scanner;

class Main23 {
    public String solution(String str){
        String answer = "";
        str = str.toLowerCase();
        char[] arr = str.toCharArray();
        int lt = 0;
        int rt = arr.length - 1;
        while (lt < rt) {
           if (arr[lt] == arr[rt]) {
               lt++;
               rt--;
           } else {
               answer = "NO";
               return answer;
           }
        }
        answer = "YES";
        return answer;
    }

    public static void main(String[] args) {
        Main23 T = new Main23();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }

}