import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N, count;
	static int[] copy, inputWord;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		copy = new int[26];
		for (int i = 0; i < str.length(); i++) {
			int index = str.charAt(i) - 'A';
			copy[index]++;
		}
		count = 0;
		
		
		
		for (int i = 0; i < N - 1; i++) {
			int word[] = copy.clone();
			String input = br.readLine();
			inputWord = new int[26];
			int check = 0;
			if (str.length() == input.length()) {
				for (int j = 0; j < input.length(); j++) {
					int index = input.charAt(j) - 'A';
					if (word[index] > 0) {
						check++;
						word[index] -= 1;
					}
				}
//				System.out.println(check);
				if (check >= str.length() - 1) {
					count++;
				}

			} else if (str.length() - input.length() == -1) {
				for (int j = 0; j < input.length(); j++) {
					int index = input.charAt(j) - 'A';
					if (word[index] > 0) {
						check++;
						word[index] -= 1;
					}
				}
//				System.out.println(check);
				if (check == str.length()) {
					count++;
				}
				
			} else if (str.length() - input.length() == 1) {
				for (int j = 0; j < input.length(); j++) {
					int index = input.charAt(j) - 'A';
					if (word[index] > 0) {
						check++;
						word[index] -= 1;
					}
				}
				if (check == str.length() - 1) {
					count++;
				}
			} else {
				continue;
			}
			
		}
		System.out.println(count);
	}
}
