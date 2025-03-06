import java.io.*;
public class Main {
    static int cnt;
    
    public static int recursion(String s, int l, int r) {
        cnt++;
        if(l >= r) return 1;
        if(s.charAt(l) != s.charAt(r)) return 0;
        return recursion(s, l + 1, r - 1);
    }
    
    public static int isPalindrome(String s) {
        cnt = 0;
        return recursion(s, 0, s.length() - 1);
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i++){
            String s = br.readLine();
            int result = isPalindrome(s);
            sb.append(result).append(" ").append(cnt).append("\n");
        }
        System.out.print(sb);
    }
}
