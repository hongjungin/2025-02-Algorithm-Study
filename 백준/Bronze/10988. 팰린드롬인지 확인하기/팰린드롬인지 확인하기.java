import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		str = str.toLowerCase();
		String tmp = new StringBuilder(str).reverse().toString();
		
		if (str.equals(tmp)) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

}
