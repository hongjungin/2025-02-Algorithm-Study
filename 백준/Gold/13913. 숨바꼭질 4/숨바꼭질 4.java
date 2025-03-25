import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 수빈이 현 위치가 X라면 그 다음 위치는 X-1, X+1, 2X
public class Main {
    static int N, K;
    static int[] map;
    static int[] time;
    static int[] before;
    static List<Integer> dist;
    static final int MAX = 100_001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[MAX];
        time = new int[MAX];
        Arrays.fill(time, -1);
        before = new int[MAX];
        Arrays.fill(before, -1);

        dist = new ArrayList<>();
        bfsStart(N);
        System.out.println(time[K]);

        if (N == K) {
            System.out.println(N);
            return;
        } else {
            int cur = K;
            while (cur != N) {
                dist.add(cur);
                cur = before[cur];
            }
            dist.add(N);
            Collections.reverse(dist);

            for (int i = 0; i < dist.size(); i++) {
                System.out.print(dist.get(i) + " ");
            }
        }

    }

    private static void bfsStart(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        before[start] = 0;
        time[start] = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : new int[]{now-1, now+1, now*2}) {
                if (next < 0 || next >= MAX) {
                    continue;
                }
                if (time[next] == -1) {
                    time[next] = time[now] + 1;
                    queue.offer(next);
                    before[next] =  now;
                }
            }
        }
    }
}
