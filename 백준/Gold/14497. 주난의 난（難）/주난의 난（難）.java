import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// * : 주난
// # : 초코바
// 1 : 친구들 0 : 빈 공간 -> 1이 갈 수 있는 곳임

// currrentQueue : 현재 비용으로 도달 가능한 노드들을 저장
// nextQueue : 비용 1 증가시켜서 도달해야하는 노드들을 저장

// 현재 레벨의 노드를 처리 -> currrentQueue 에 있는 모든 노드 꺼내서 처리
// 그 노드들의 인접 노드 4방 확인 -> 모두 처리 후 레벨 1 증가
// 1이면 nextQueue에 추가

public class Main {
    static int N, M;
    static int jump;
    static int startX, startY, finishX, finishY;
    static char[][] school;
    static  boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        startX = Integer.parseInt(st.nextToken()) - 1;
        startY = Integer.parseInt(st.nextToken()) - 1;
        finishX = Integer.parseInt(st.nextToken()) - 1;
        finishY = Integer.parseInt(st.nextToken()) - 1;

        school = new char[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                school[i][j] = line.charAt(j);
            }
        }
        jump = 0;
        int result = bfs(startX, startY);
        System.out.println(result);
    }
    private static int bfs(int x, int y) {
        Queue<int[]> currentNode = new ArrayDeque<>();
        Queue<int[]> nextNode = new ArrayDeque<>();
        currentNode.offer(new int[]{x, y});
        visited[x][y] = true;

        while(!currentNode.isEmpty()) {

            int currentNodeSize = currentNode.size();
            // 0인 곳 동시에 다 돌려
            for (int i = 0; i < currentNodeSize; i++) {
                int[] node = currentNode.poll();
                int cx = node[0];
                int cy = node[1];

                for (int j = 0; j < 4; j++) {
                    int nx = cx + dx[j];
                    int ny = cy + dy[j];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
                        if (nx == finishX && ny == finishY) {
                            jump++;
                            return jump;
                        }
                        visited[nx][ny] = true;
                        if (school[nx][ny] == '0') {    // 비용 추가 x
                            currentNode.offer(new int[]{nx, ny});
                        } else if (school[nx][ny] == '1') {
                            nextNode.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
            if (currentNode.isEmpty()) {
                jump++;
                currentNode = nextNode;
                nextNode = new ArrayDeque<>();
            }
        }
        return -1; // 도달x
    }

}
