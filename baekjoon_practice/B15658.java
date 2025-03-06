import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// N개의 수로 이루어진 수열, 수와 수 사이 끼워넣을 수 있는 N-1개의 연산자(+ - * /)
// 만들 수 있는 식의 결과가 최대인 것과 최소인 것.

// 여러 개를 다 해보고 그 중에 최대 최소 정함 -> 완탐
// 숫자는 위치 변경 안함. 연산자만 순서 변경 가능.
// 1. 숫자랑 연산자를 같은 곳에 저장 ? X
// 2. 숫자랑 연산자랑 따로 저장 ? -> 고정 길이니까 배열에 저장.

// 연잔사는 어떻게 저장할래. 2 1 1 1 이면 -> 숫자가 아니니까 어떻게 처리해야함...
// 순서를 나열하니까 perm 쓰는 거 같은데 이게 숫자가 아니라 연산자니까
// 어떻게 나열할지 모르겠네


public class B15658 {
    static int N, R, sum;
    static int[] nums;
    static int[] input;
    static int[] operator;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        sum = 0;
        input = new int[4];
        for (int i = 0; i < 4; i++) {
            input[i] = Integer.parseInt(st.nextToken());
            sum += input[i];
        }

        R = N - 1;
        operator = new int[sum];
        visited = new boolean[sum];
        int num = 1;
        int index = 0;
        for (int i = 0; i < 4; i++) {
            int a = input[i];
            for (int j = 0; j < a; j++) {
                operator[index] = num;
                index++;
            }
            num++;
        }

        calculate(0, nums[0]);
        System.out.println(max);
        System.out.println(min);
    }

    private static void calculate(int depth, int tot) {
        if (depth == R){
            if (tot < min){
                min = tot;
            }

            if (tot > max) {
                max = tot;
            }

            return;
        }

        for (int i = 0; i < sum; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;

            if (operator[i] == 1) calculate(depth+1, tot + nums[depth+1]);
            if (operator[i] == 2) calculate(depth+1, tot - nums[depth+1]);
            if (operator[i] == 3) calculate(depth+1, tot * nums[depth+1]);
            if (operator[i] == 4) calculate(depth+1, tot / nums[depth+1]);
            visited[i] = false;
        }
    }
}