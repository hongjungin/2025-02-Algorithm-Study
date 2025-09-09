import java.util.*;
import java.io.*;

// 송아지 고정
// 현수 앞으로 1 뒤로 1 앞으로 5 이동 가능
// 최소 몇번으로 송아지 위치 감?
// S 현수 E 송아지
// 하나에서 3개씩 퍼져나가는 구조

class Main_1 {
    int answer = 0;
    int[] dis = {1, -1, 5};
    int[] check;
    Queue<Integer> q = new LinkedList<>();

    public int BFS(int s, int e) {
        check = new int[10001];
        check[s] = 1;
        q.offer(s);
        int L = 0;

        while(!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                int x = q.poll();
                for (int d : dis) {
                    int nx = x + d;
                    if (nx == e) return L+1;
                    if(nx >= 1 && nx < 10000 && check[nx] == 0) {
                        check[nx] = 1;
                        q.offer(nx);
                    }
                }
            }
            // 레벨 증가
            L++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Main_1 T = new Main_1();
        Scanner kb = new Scanner(System.in);
        int s = kb.nextInt();
        int e = kb.nextInt();
        System.out.println(T.BFS(s , e));
    }


}
