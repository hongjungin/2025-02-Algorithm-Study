import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] peoples;
	static int[] rank;
	static List<Integer> truths;
	static List<List<Integer>> parties;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		truths = new ArrayList<>();
		peoples = new int[N + 1];
		rank = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			peoples[i] = i;
		}
				
		st = new StringTokenizer(br.readLine());
		int count = Integer.parseInt(st.nextToken());
		if (count == 0) {
			System.out.println(M);
			return; 
		}
		int start = Integer.parseInt(st.nextToken());
		truths.add(start);
		// 진실을 아는 사람
		for (int i = 1; i < count; i++) {
			int next = Integer.parseInt(st.nextToken());
			union(start, next);
			truths.add(next);
		}
		
//		System.out.println(N + " " + M);
//		for (int i = 0; i < N + 1; i++) {
//			System.out.print(peoples[i] + " ");
//		}
		
//		for (int t : truths) {
//			System.out.print(t + " ");
//		}

		
		// 파티 시작
		parties = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            List<Integer> party = new ArrayList<>();
            for (int j = 0; j < num; j++) {
                party.add(Integer.parseInt(st.nextToken()));
            }
            parties.add(party);

            // 파티에 나온 사람들끼리 union
            for (int j = 0; j < party.size() - 1; j++) {
                union(party.get(j), party.get(j + 1));
            }
        }
		
		int result = 0;
		for (List<Integer> party : parties) {
            boolean canLie = true;

            for (int person : party) {
                for (int truth : truths) {
                    if (find(person) == find(truth)) {
                        canLie = false;
                        break;
                    }
                }
                if (!canLie) break;
            }
            if (canLie) result++;
        }
		
		System.out.println(result);
		
	}
	private static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if (rootA == rootB) return;
		peoples[rootB] = rootA;
	}
	
	private static int find(int a) {
		if (peoples[a] == a) {
			return peoples[a];
		}
		return peoples[a] = find(peoples[a]);
	}

}
