import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 6 : 벽 0 : 빈칸 1~5 씨씨티비
// 방향 경우의 수 -> 4개 (상하좌우)
// -> 좌우/상하 2개
// -> 3방향 4개
// -> 네 방향 1개
// -> 4개
public class B15683 {
    static int N, M;
    static int[][] office;
    static int minBuilding;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static List<int[]> getDirections(int type) {
        List<int[]> dirList = new ArrayList<>();

        switch (type) {
            case 1:
                dirList.add(new int[]{0});
                dirList.add(new int[]{1});
                dirList.add(new int[]{2});
                dirList.add(new int[]{3});
                break;
            case 2:
                dirList.add(new int[]{0, 2}); // 좌우
                dirList.add(new int[]{1, 3}); // 상하
                break;
            case 3:
                dirList.add(new int[]{0, 1}); // 우하
                dirList.add(new int[]{1, 2}); // 하좌
                dirList.add(new int[]{2, 3}); // 좌상
                dirList.add(new int[]{3, 0}); // 상우
                break;
            case 4:
                break;
            case 5:
                dirList.add(new int[]{0, 1, 2, 3});
                break;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        office = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                office[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, office);
    }

    static void dfs(int x, int y, int[][] of) {
        if(x == N) {
            return;
        }
    }
}
