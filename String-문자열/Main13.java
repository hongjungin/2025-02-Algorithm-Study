import java.util.Scanner;
import java.util.StringTokenizer;

class Main13 {
    public int solution(int n, int[] arr){
        int count = 1;
        int max = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                count += 1;
                max = arr[i];
            }
        }
        return count;
    }

    public static void main(String[] args){
        Main13 T = new Main13();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(T.solution(n, arr));
    }

}