import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static int T, N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>(); // 의상 종류별 개수 저장

            for (int i = 0; i < N; i++) {
                String[] input = br.readLine().split(" ");
                String category = input[1];

                map.put(category, map.getOrDefault(category, 0) + 1);
            }

            int result = 1;
            for (int count : map.values()) {
                result *= (count + 1);
            }

            System.out.println(result - 1); // 아무것도 안 입는 경우 뺌
        }
        
    }
}
