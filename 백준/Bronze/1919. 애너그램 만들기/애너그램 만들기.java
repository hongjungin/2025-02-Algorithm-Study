import java.util.Scanner;

public class Main {
	// 2개의 단어를 배열에 저장,
	// 같은 단어는 따로 또 배열에 저장
	// 그걸 삭제하고 남은 갯수 count
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word1 = sc.nextLine();
		String word2 = sc.nextLine();
		word1 = word1.toLowerCase();
		word2 = word2.toLowerCase();
		
		int[] a1 = new int[26];
		int[] a2 = new int[26];
		
		for (char x1 : word1.toCharArray()) {
			if (x1 >= 'a' && x1 <= 'z') { 
		        a1[x1 - 'a']++;
		    }
		}
		for (char x2 : word2.toCharArray()) {
			if (x2 >= 'a' && x2 <= 'z') {
		        a2[x2 - 'a']++;
		    }
		}
		
		// 2개의 배열을 비교해서 그 나머지 숫자 더하기...
		int count = 0;
		for (int i = 0; i < 26; i++) {
			 count += Math.abs(a1[i] - a2[i]);
		}
		
		System.out.println(count);
	}

}
