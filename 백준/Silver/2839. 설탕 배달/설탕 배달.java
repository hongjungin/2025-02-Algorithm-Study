// N 킬로그램 배달해야함
// 봉지는 3이나 5
// 최대한 봉지 수 적게

import java.util.Scanner;

public class Main {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		int five = 0;
		int three = 0;
		int result = 0;
		
		five = N / 5;
		int rest = N % 5;
		
		while(true) {
			if (rest % 3 == 0) {
				three = rest / 3;
				result = five + three;
				break;
			} else if (five >= 1) {
				five--;
				rest += 5;
			}
			if (five == 0 && rest % 3 != 0) {
				result = -1;
				break;
			}
			
		}
		
		System.out.println(result);
	}

}
