import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// N개의 노드 가 있어 -> 각 노드의 부모를 찾아.
// 로트 노드는 1번.
// 연결관계만 주어지고 탐색을 통해서 부모를 찾아야해. -> dfs 이용해야할 거 같은데
// 중복되면 안돼,

public class B11725 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        List<Integer>[] adjList = new ArrayList[N + 1];

        // 인접 리스트 초기화
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }
        // 관계를 인접리스트에 저장.
        for (int i = 1; i <= N-1; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            adjList[a].add(b);
        }
    }
}
