import java.util.*;
import java.io.*;

// 한 컴퓨터가 바이러스 -> 연결된 애들 다 바이러스
// 양방향 그래프 탐색 문제
// 배열 안에 리스트인 형식

public class Main_2606 {
    static int num;
    static int N, result;
    static List<Integer>[] computers;
    static boolean[] visited;

    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());

        computers = new ArrayList[num + 1];

        for (int i = 1; i < num + 1; i++) {
            computers[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            computers[a].add(b);
            computers[b].add(a);
        }

        visited = new boolean[num + 1];
        result = 0;
        dfs(1);

        System.out.println(result);
    }

    static void dfs (int start) {
        visited[start] = true;

        for (int c : computers[start]) {
            if (!visited[c]) {
                visited[c] = true;
                result++;
                dfs(c);
            }
        }

    }
}
