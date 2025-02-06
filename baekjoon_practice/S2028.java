import java.util.Scanner;

public class S2028 {
    static int N;
    static int[] prices;
    static int[] ranks;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        prices = new int[N];
        ranks = new int[N];

        // 상품 가격 입력
        for (int i = 0; i < N; i++) {
            prices[i] = sc.nextInt();
        }
        
        // 등수 계산
        for (int i = 0; i < N ; i++) {
            int rank = 1;
            for (int j = 1; j < N ; j++) {
                if (prices[i] < prices[j]) {
                    rank++;
                }
            }
            ranks[i] = rank;
        }

        for (int rank : ranks) {
            System.out.print(rank + " ");
        }
    }
}
