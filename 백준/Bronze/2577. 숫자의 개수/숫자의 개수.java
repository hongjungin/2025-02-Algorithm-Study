import java.util.Scanner;
public class Main {
	static int A;
	static int B;
	static int C;
	static int result;
	static int[] count;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();
		result = A * B * C;
		
		if (A < 100 || A > 1000 || B < 100 || B > 1000 || C < 100 || C > 1000) {
			sc.close();
			return;
		}
		
		String strNum = Integer.toString(result);
		count = new int[10];
		
		for (int i = 0; i < strNum.length(); i++) {
			int num = strNum.charAt(i) - '0';
			count[num]++;
		}
		
		for (int i = 0; i < count.length; i++) {
			System.out.println(count[i]);
		}
		
		sc.close();
	}
}
