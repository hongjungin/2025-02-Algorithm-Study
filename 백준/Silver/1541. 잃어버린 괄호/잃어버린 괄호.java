import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		String[] inputs = input.split("-");
		int sum = 0;
		int first = sum(inputs[0]);
		int result = first;
		for (int i = 1; i < inputs.length; i++) {
			result -= sum(inputs[i]);
		}
		System.out.println(result);
	}

	private static int sum(String string) {
		String[] nums = string.split("\\+");
		int calulate = 0;
		for (String num : nums) {
			calulate += Integer.parseInt(num);
		}
		return calulate;
	}

}

