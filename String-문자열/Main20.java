import java.util.Scanner;

class Main20 {
    public String solution(int N, String[] arr){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            String str = arr[i];
            char[] chars = str.toCharArray();
            for(int j = chars.length; j > 0; j--){
                sb.append(chars[j-1]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Main20 T = new Main20();
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        kb.nextLine();
        String[] arr = new String[N];
        for (int i = 0; i < N; i++){
            arr[i] = kb.nextLine();
        }
        System.out.println(T.solution(N, arr));
    }

}