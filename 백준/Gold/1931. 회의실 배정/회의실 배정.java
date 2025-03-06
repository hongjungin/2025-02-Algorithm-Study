import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

// N 개의 회의
// 각 회의는 시작시간 끝나는 시간
// 회의가 겹치지 않고 회의실을 사용하는 최대개수

public class Main {
    static int N;
    static int curTime, count;
    static List<int[]> meeting;
    static List<int[]> select;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        meeting = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            meeting.add(new int[] {a, b});
        }

        meeting.sort(Comparator.comparingInt((int[] arr) -> arr[1])
                .thenComparingInt(arr -> arr[0]));
        select = new ArrayList<>();
        count = 0;
        curTime = 0;
        for (int i = 0; i < N; i++) {
            if (curTime <= meeting.get(i)[0]) {
                curTime = meeting.get(i)[1];
                count++;
            }
        }
        System.out.println(count);
    }

}
