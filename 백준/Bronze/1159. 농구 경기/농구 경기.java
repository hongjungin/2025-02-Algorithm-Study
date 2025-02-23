import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	// 성의 첫 글자가 같은 선수 5명을 선발 
	// 만약 5보다 적으면 -> 기권 -> ; 출력
	
	// 크기 정해짐 -> 배열을 쓸까
	// 알파벳같이 이런 것들은 따로 배열을 만들지 않고 위치를 사용.
	// 중복되는 애들은 어떻게 처리함? -> hashmap?.. -> 이걸 쓸거면 알파벳 순으로 출력할 수 있게
	// Treemap 같은 거 사용해야함.
	static int N;
	static int[] index;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		index = new int[26];
		
		for (int i = 0; i < N; i++) {
			// charAt은 해당 인덱스의 문자만 추출 -> char 형태
			char c = br.readLine().charAt(0);
			index[c - 'a']++;
		}
		
		for (int i = 0; i < index.length; i++) {
			if (index[i] >= 5) {
				char name = (char) ('a' + i);
				sb.append(name);
			} 
		}
		
		if (sb.length() == 0) {
			System.out.println("PREDAJA");
		} else {
			System.out.println(sb);
		}
		
		
	}

}