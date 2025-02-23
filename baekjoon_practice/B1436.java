
// 666 부터 1666 2666 3666 ...
// 666은 연달아 나와야함. 사실 그냥 6으로 봐도 무방하지.
// N번째 -> 쭉 배열하다가 N이 나오면 끝나게?
// N이 10,000
// 일단 시작은 완탐으로 해. 제일 작은게 666이니까 666부터


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1436 {
    static int N;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        count = 0;
        int num = 666;
        int answer = 0;

        while (count < N) {
            String str = String.valueOf(num);
            if (str.contains("666")) {
                count++;
                answer = Integer.parseInt(str);
            }
            num++;
        }

        if (count == N) {
            System.out.println(answer);
        }
    }
}
