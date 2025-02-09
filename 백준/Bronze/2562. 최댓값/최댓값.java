import java.util.Iterator;
import java.util.Scanner;
public class Main {
	static int max;
	static int num;
	static int index;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		max = Integer.MIN_VALUE;
		num = 0;
		index = 1;
		
		for (int i = 1; i <= 9; i++) {
			num = sc.nextInt();
			
			if (num < 1 || num >= 100) {
				return;
			}
			
			if (num > max) {
				max = num;
				index = i;
			}
		}
		
		sc.close();
		
		System.out.println(max);
		System.out.println(index);
	}
}
