import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 동전은 N종류
// 그 가치의 합을 K로 만듦
// 이때 필요한 동전 개수의 최솟값?
public class Main {
	static int N, K;
	static int[] coins;
	static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int index = 0;
		int rest = K;
		count = 0;
		
		coins = new int[N];
		for (int i = 0; i < N; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		index = N - 1;
		while(index >= 0) {
			if (rest == 0) {
				break;
			}
			if (rest < coins[index]) {
				index--;
				continue;
			}
			int coin = K / coins[index];
			count += coin;
			rest = K % coins[index];
			index--;
			K = rest;
		}
		
		System.out.println(count);
	}

}
