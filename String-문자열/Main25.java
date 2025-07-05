import java.util.Scanner;

class Main25 {
    public int solution(String str){
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        char[] arr = str.toCharArray();
        for(int i = 0; i < arr.length; i++){
            if(Character.isDigit(arr[i])){
                sb.append(arr[i]);
            }
        }
        answer = Integer.parseInt(sb.toString());
        return answer;
    }

    public static void main(String[] args) {
        Main25 T = new Main25();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }

}