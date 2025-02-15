import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
public class B15686 {
    // 0 : 빈칸, 1 : 집, 2 : 치킨
    // 치킨 거리 = 집에서 가장 가까운 치킨집 사이의 거리
    // 도시의 치킨 거리는 모든 집의 치킨 거리 합 -> 집이 기준
    // M개의 치킨 집 선택 -> 조합

    // 1) 집과 치킨집의 위치를 리스트에 저장 -> 왜 리스트? -> 길이가 고정적이지 않음.
    // 2) 거리를 계산해서 저장 (집 ~ 치킨집 거리)
    // 3) 최대 M개의 치킨집을 골라
    static int N, M;
    static int[][] city;
    static boolean[] visited;
    static ArrayList<int[]> houses;
    static ArrayList<int[]> chickens;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        city = new int[N][N];
        // 입력값 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 집과 치킨집의 위치를 리스트에 저장
        houses = new ArrayList<>();
        chickens = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 1) {
                    houses.add(new int[]{i, j});
                } else if (value == 2) {
                    chickens.add(new int[]{i, j});
                }
            }
        }


    }
}
