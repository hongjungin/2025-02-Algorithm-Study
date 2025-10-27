import java.util.*;
import java.io.*;

// 내림차순 정렬 -> 등수 작은거가 됨
// 새로운 점수 몇 등이냐 ? 랭킹에 못올라가면 -1 출력
// 랭킹에 올라가는 점수 개수 P (10<= <= 50)
// 입력 점수 N
// 랭킹 리스트가 차면 -> 이전보다 높아야 바뀜
// 모든 점수 20억보다 작음

public class B1205 {
    static int N, newScore, P;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        if (N == 0) {
            System.out.println(1);
            return;
        }
        newScore = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int rank = 1;

        if (N == P) {
            if (newScore <= arr[N-1]) {
                rank = -1;
                System.out.println(rank);
                return;
            } else {
                for (int i = 0; i < N; i++) {
                    if (newScore >= arr[i]) {
                        System.out.println(rank);
                        return;
                    } else {
                        rank++;
                    }
                }
                System.out.println(rank);
            }

        } else if (N < P) {
            for (int i = 0; i < N; i++) {
                if (newScore >= arr[i]) {
                    System.out.println(rank);
                    return;
                } else {
                    rank++;
                }
            }
            System.out.println(rank);
        }
    }
}
