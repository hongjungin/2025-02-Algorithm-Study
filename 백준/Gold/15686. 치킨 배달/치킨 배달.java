import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static class Point {
        int r, c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static ArrayList<Point> houses = new ArrayList<>();
    static ArrayList<Point> chickens = new ArrayList<>();
    static boolean[] selected;
    static int ans = Integer.MAX_VALUE;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 집, 치킨집 리스트에 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                int input = Integer.parseInt(st.nextToken());

                if (input == 1) {
                    houses.add(new Point(i,j));
                } else if (input == 2) {
                    chickens.add(new Point(i,j));
                }
            }
        }

        selected = new boolean[chickens.size()];
        // M개 선택 -> 조합
        combi(0,0);
        
        System.out.println(ans);
    }

    private static void combi(int depth, int start) {
        // 여기서 맨해튼 거리 계산
        if (depth == M) {
            int totalCityDist = 0;

            for (Point h : houses) {
                int minDist = Integer.MAX_VALUE;

                for (int i = 0; i < chickens.size(); i++) {
                    if (selected[i]) {
                        int dist = Math.abs(chickens.get(i).r - h.r) + Math.abs(chickens.get(i).c - h.c);
                        minDist = Math.min(minDist, dist);
                    }
                }
                totalCityDist += minDist;
            }
            ans = Math.min(ans, totalCityDist);

            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            selected[i] = true;
            combi(depth + 1, i + 1);
            selected[i] = false;

        }
    }
}
