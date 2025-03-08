import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] land = new int[N][M];
        int minH = 256, maxH = 0;

        // 입력 받기 & 높이 범위 찾기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                land[i][j] = Integer.parseInt(st.nextToken());
                minH = Math.min(minH, land[i][j]);
                maxH = Math.max(maxH, land[i][j]);
            }
        }

        int minTime = Integer.MAX_VALUE;
        int bestHeight = minH;

        // 0 ~ 256 높이까지 모든 경우 확인
        for (int h = minH; h <= maxH; h++) {
            int removeBlocks = 0, addBlocks = 0;

            // 블록 추가/제거 연산 계산
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int diff = land[i][j] - h;
                    if (diff > 0) removeBlocks += diff; // 블록 제거
                    else addBlocks -= diff; // 블록 추가
                }
            }

            // 블록 개수 체크
            if (removeBlocks + B >= addBlocks) {
                int time = removeBlocks * 2 + addBlocks * 1; // 총 시간 계산

                // 최소 시간 & 최대 높이 갱신
                if (time < minTime || (time == minTime && h > bestHeight)) {
                    minTime = time;
                    bestHeight = h;
                }
            }
        }

        System.out.println(minTime + " " + bestHeight);
    }
}
