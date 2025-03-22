import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 수빈이 현 위치가 X라면 그 다음 위치는 X-1, X+1, 2X
public class Main {
    static int N, K;
    static int[] map;
    static int[] time;
    static final int MAX = 100_001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[MAX];
        time = new int[MAX];
        Arrays.fill(time, -1);
        bfsStart(N);
        System.out.println(time[K]);
    }

    private static void bfsStart(int start) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        time[start] = 0;

        while (!queue.isEmpty()) {
            int now = queue.pollFirst();

            for (int next : new int[]{now * 2, now - 1, now + 1}) {
                if (next < 0 || next >= MAX) {
                    continue;
                }
                if (time[next] == -1) {
                    if (next == now * 2) { // 먼저 넣음
                        time[next] = time[now];
                        queue.addFirst(next);
                    } else {
                        time[next] = time[now] + 1;
                        queue.addLast(next);
                    }
                }

            }

        }
    }
}
