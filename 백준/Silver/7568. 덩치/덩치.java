import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	// 크기가 정해져있으니까 배열로 풀어야할 거 같은데.
	// 일단 몸무게, 키 이렇게 묶여있으니까 hashmap을 사용해볼까?
	// 등수를 저장할 배열을 만들어야겠다.
	static int N;
	static int[] rank;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		List<int[]> people = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			people.add(new int[] {weight, height});
		}
		
		rank = new int[N];
		Arrays.fill(rank, 1);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i != j) {
					if (people.get(i)[0] > people.get(j)[0] && people.get(i)[1] > people.get(j)[1]) {
						rank[j]++;
					}
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			System.out.print(rank[i] + " ");
		}
	}

}
