import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 수빈이 현 위치가 X라면 그 다음 위치는 X-1, X+1, 2X
public class B12851 {
    static int N, K;
    static int[] map;
    static int[] count;
    static int[] time;
    static final int MAX = 100_001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[MAX];
        count = new int[MAX];
        time = new int[MAX];
        Arrays.fill(time, -1);
        bfsStart(N);
        System.out.println(time[K]);
        System.out.println(count[K]);
    }

    private static void bfsStart(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        count[start] = 1;
        time[start] = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : new int[]{now-1, now+1, now*2}) {
                if (next < 0 || next >= MAX) {
                    continue;
                }
                if (time[next] == -1) { // 방문 안한것임
                    count[next] = count[now]; // count -> 경우의 수
                    time[next] = time[now] + 1;
                    queue.offer(next);
                } else if (time[next] == time[now] + 1) { // 이미 와본적이 있는 길 -> 경우의 수 추가
                    count[next] += count[now];
                }
            }

        }
    }
}
