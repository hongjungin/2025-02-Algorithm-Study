import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.nextLine();
		
		word = word.toUpperCase();
		int[] count = new int[26];
		int max = Integer.MIN_VALUE;
		int n = 0;
		
		for (char c : word.toCharArray()) {
			int index = c - 'A';
			count[index]++;
		}
		
		// 최댓값을 max에 저장
		for (int i = 0; i < count.length; i++) {
			max = Math.max(max, count[i]);	
		}
		
		// 배열에 max값이 또 있다면 -> 물음표 출력하는 로직
		int answer = -1;
		boolean find = false;
		for (int i = 0; i < count.length; i++) {
			if (count[i] == max) {
				if(find) {
					System.out.println("?");
					return;
				}
				find = true;
				answer = i;
			}
		}
		System.out.println((char)('A' + answer));
		
		
	}
}
