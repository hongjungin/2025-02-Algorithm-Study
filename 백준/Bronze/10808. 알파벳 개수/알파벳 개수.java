import java.util.Scanner;

public class Main {
	static int[] alphabet;
	static String word;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		word = sc.nextLine();
		
		char[] c = word.toCharArray();
		alphabet = new int[26];
		
		for (char x : c) {
			alphabet[x - 'a']++;
		}
		
		for (int i = 0; i < alphabet.length; i++) {
			System.out.print(alphabet[i] + " ");
		}
	}
}