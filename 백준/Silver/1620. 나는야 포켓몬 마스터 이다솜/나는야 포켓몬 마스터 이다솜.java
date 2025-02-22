import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 포켓몬 개수
        int M = Integer.parseInt(st.nextToken()); // 문제 개수

        HashMap<String, Integer> nameToNum = new HashMap<>();
        ArrayList<String> numToName = new ArrayList<>(N + 1);

        numToName.add(""); // 0번 인덱스는 사용하지 않음 (1부터 시작)

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            nameToNum.put(name, i); // 포켓몬 이름 → 번호 매핑
            numToName.add(name);    // 번호 → 포켓몬 이름 매핑
        }

        for (int i = 0; i < M; i++) {
            String query = br.readLine();
            if (Character.isDigit(query.charAt(0))) {
                // 숫자인 경우 → 번호 → 이름 조회
                int num = Integer.parseInt(query);
                bw.write(numToName.get(num) + "\n");
            } else {
                // 문자열인 경우 → 이름 → 번호 조회
                bw.write(nameToNum.get(query) + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
