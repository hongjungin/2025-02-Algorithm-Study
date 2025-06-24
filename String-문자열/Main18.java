import java.util.Scanner;

class Main18 {
    public String solution(String str){
        // 입력받은 문자열이 대문자인지 소문자인지 어떻게 알지?
        // 일단 문자열을 돌면서? 봐야하니, charArray로 바꿔야할까?
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isUpperCase(c)) { // 대문자일때
                char ch = Character.toLowerCase(c);
                sb.append(ch);
            } else { // 소문자일 때
                char ch = Character.toUpperCase(c);
                sb.append(ch);
            }
        }

        String answer = sb.toString();
        return answer;
    }

    public static void main(String[] args) {
        Main18 T = new Main18();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }

}