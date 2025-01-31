import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// combi 넣어서 풀기
public class Main {
	static int N;
	static int num = 3;
	static int M;
	static int[] cards;
	static int sum;

	public static void main(String[] args) throws Exception{
		// 입력값 받기
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		cards = new int[N];
		// 한 줄 숫자입력 받을 때 for문 바깥에 있어야함.
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		sum = 0;
		combi(0,0,0);
		System.out.println(sum);
	}

	private static void combi(int cnt, int start, int sumMax) {
		if (sumMax > M) {
			return;
		}
		if (cnt == num) {
			sum = Math.max(sum, sumMax);
			return;
		}
		
		for (int i = start; i < N; i++) {
			combi(cnt+1, i + 1, sumMax + cards[i]);
		}
	}

}
