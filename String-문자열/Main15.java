import java.util.Scanner;

class Main15 {
    public String solution(int n, int[] arrA, int[] arrB){
        String answer = "";


        return answer;
    }

    public static void main(String[] args) {
        Main15 T = new Main15();
        Scanner kb = new Scanner(System.in);
        int n = Integer.parseInt(kb.nextLine());
        int[] arrA = new int[n];
        int[] arrB = new int[n];
        for (int i = 0; i < n; i++) {
            arrA[i] = kb.nextInt();
        }
        System.out.println(T.solution(n, arrA, arrB));
    }

}