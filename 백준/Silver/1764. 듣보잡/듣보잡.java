import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 듣도 못한 사람 수
        int M = Integer.parseInt(st.nextToken()); // 보도 못한 사람 수

        Set<String> unheard = new HashSet<>(); // 듣도 못한 사람 저장
        List<String> result = new ArrayList<>(); // 듣보잡 저장

        for (int i = 0; i < N; i++) {
            unheard.add(br.readLine()); // 듣도 못한 사람 저장
        }

        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (unheard.contains(name)) { // 듣도 못한 사람 목록에 있으면
                result.add(name); // 듣보잡에 추가
            }
        }

        Collections.sort(result); // 사전순 정렬
        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n"); // 듣보잡 개수 출력
        for (String name : result) {
            sb.append(name).append("\n");
        }

        System.out.print(sb);
    }
}
