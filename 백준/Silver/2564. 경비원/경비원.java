import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int width, height, total, N;
    static int dong;
    static int[] store;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());

        N = Integer.parseInt(br.readLine());
        store = new int[N]; // 상점 위치 저장 배열
        total = (width + height) * 2; // 직사각형 둘레

        // 상점 위치 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int pos = Integer.parseInt(st.nextToken());
            store[i] = convertPosition(dir, pos);
        }

        // 동근이 위치 입력
        st = new StringTokenizer(br.readLine());
        int dir = Integer.parseInt(st.nextToken());
        int pos = Integer.parseInt(st.nextToken());
        dong = convertPosition(dir, pos);

        // 최단 거리 계산
        int sum = 0;
        for (int i = 0; i < N; i++) {
            int dist = Math.abs(store[i] - dong);
            sum += Math.min(dist, total - dist);
        }

        System.out.println(sum);
    }

    // 위치 변환 함수
    static int convertPosition(int dir, int pos) {
        if (dir == 1) return pos; // 북쪽
        if (dir == 2) return width + height + (width - pos); // 남쪽
        if (dir == 3) return width * 2 + height + (height - pos); // 서쪽
        return width + pos; // 동쪽
    }
}
