
// * 위치 찾아서 앞 뒤로 나눠

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int index = str.indexOf('*');
        String start = str.substring(0, index);
        String ennd = str.substring(index + 1);

        for (int i = 0; i < N; i++) {
            String fileName = br.readLine();
            // 이 조건 빼먹음
            if (fileName.length() < start.length() + ennd.length()) {
                System.out.println("NE");
                continue;
            }

            if (fileName.startsWith(start) && fileName.endsWith(ennd)) {
                System.out.println("DA");
            } else {
                System.out.println("NE");
            }
        }

    }
}
