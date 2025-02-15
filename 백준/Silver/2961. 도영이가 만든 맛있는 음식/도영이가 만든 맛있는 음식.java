import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, S ,B;
	// N : 재료의 개수 S : 신맛 B : 쓴맛
	// 신맛은 곱 쓴 맛은 합
	//신맛과 쓴맛의 차이가 가장 작은 요리.
	static int[] sour;
	static int[] bitter;
	static boolean[] selected;
	static int cook;
	static int minCook;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		sour = new int[N];
		bitter = new int[N];
		minCook = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sour[i] = Integer.parseInt(st.nextToken());
			bitter[i] = Integer.parseInt(st.nextToken());
		}
			
		
		selected = new boolean[N];
		
		subset(0);
		System.out.println(minCook);
	}

	static void subset(int depth) {
		if (depth == N) {
			
			minCook = Math.min(cooking(), minCook);
			return;
		}
		selected[depth] = true;
		subset(depth + 1);
		
		selected[depth] = false;
		subset(depth + 1);
	}

	static int cooking() {
		int sourT = 1;
		int bitterT = 0;
		cook = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			if (selected[i]) {
				 sourT *= sour[i];
				 bitterT += bitter[i];
			}		
		}
		if (bitterT == 0) {
			return Integer.MAX_VALUE;
		}
		cook = Math.abs(sourT - bitterT);
		return cook;
	}

}