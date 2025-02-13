import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// T 입력 받기
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < T; i++) {
			String input = br.readLine();
			// 배열에 단어들을 저장.
			String[] words = input.split("\\s+");

			for (int j = 0; j < words.length; j++) {
				String s = words[j];
				String reversed = new StringBuilder(s).reverse().toString();
				sb.append(reversed).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
}