import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {
    // 여러 줄 문자열 입력
    // 숫자 추출
    // 숫자 -> 정수 오름차순 정랼
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<String> numbers = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            // 공백없으니까 StringTokenizer 굳이 필요 X
            String s = br.readLine();
            // 변수 num에 임시 저장 -> 문자 만나기 전까지 저장 후 list에 넘겨
            StringBuilder num = new StringBuilder();

            for (char c : s.toCharArray()) {
                if (Character.isDigit(c)) {
                    num.append(c);
                } else if (num.length() > 0) {
                    numbers.add(num.toString().replaceFirst("^0+","").isEmpty() ? "0" : num.toString().replaceFirst("^0+", ""));
                    // num 변수 초기화
                    num.setLength(0);
                }
            }
            // 맨 마지막 숫자 생각 못함
            if (num.length() > 0) {
                numbers.add(num.toString().replaceFirst("^0+", "").isEmpty() ? "0" : num.toString().replaceFirst("^0+", ""));
            }
        }
        // 오름차순 정렬
        // Collections.sort() 쓰면 문자열이라 안됨
        // 문자열 길이 비교 + 그 다음 오름차순 비교
        numbers.sort((num1, num2) -> {
            if (num1.length() != num2.length()){
                return num1.length() - num2.length();
            }
            return new BigInteger(num1).compareTo(new BigInteger(num2));
        });
        for (String number : numbers) {
            System.out.println(number);
        }
    }
}
