import java.util.Scanner;

class Main22 {
    public String solution(String str){
        String answer = "";
        StringBuilder sb = new StringBuilder();

        int[] cnt = new int[26];
        char[] s = str.toCharArray();
        for (int i = 0; i< s.length; i++) {
            if (cnt[s[i]-'a'] == 0){
                cnt[s[i]-'a']++;
                sb.append(s[i]);
            } else {
                continue;
            }
        }
        answer = sb.toString();
        return answer;
    }

    public static void main(String[] args) {
        Main22 T = new Main22();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }

}