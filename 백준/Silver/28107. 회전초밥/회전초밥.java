import java.io.*;
import java.util.*;

// 손님 N명, 요리사는 M개 초밥 만듦
// 1번부터 N번 손님 순서대로 초밥을 받음
// 목록에 적힌 초밥이 오면 반드시 먹음
// 목록에 없으면 안먹음
// 각 종류는 최대 한 번만 먹음
// 각 손님이 먹게 되는 초밥의 개수는?

// 1<=N<=100,000 1<=M<=200,000
public class Main {

    static int N, M;
    static PriorityQueue<Integer>[] want;
    static int[] eat;
    static int MAX = 200_000;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        want = new PriorityQueue[MAX + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            for (int j = 0; j < num; j++) {
                int type = Integer.parseInt(st.nextToken());
                
                if (want[type] == null) {
                    want[type] = new PriorityQueue<>();
                }
                
                want[type].add(i);
            }
        }

        eat = new int[N+1];
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < M; i++) {
            int foodType = Integer.parseInt(st.nextToken());
            
            if (want[foodType] != null && !want[foodType].isEmpty()) {
                int p = want[foodType].poll();
                eat[p]++; 
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(eat[i]);
            if (i < N) sb.append(' ');
        }
        System.out.println(sb);
    }
}
