import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	// 0 : 빈칸, 1 : 집, 2 : 치킨
	// M개 선택 -> perm or combi? 
	// 최대 M개를 고름 -> 부분 집합
	
	// 1) 집과 치킨집의 위치를 리스트에 저장 -> 왜 리스트? -> 길이가 고정적이지 않음.
	// 2) 거리를 계산해서 저장
	// 3) 최대 M개의 치킨집을 골라
	static int N, M;
	static int[][] city;
	static boolean[] visited;
	static ArrayList<int[]> houses;
	static ArrayList<int[]> chickens;
	static ArrayList<int[]> selectChick;
	static int minChickenDistance = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());       // 선택할 개수
		
		city = new int[N][N];
		// 집과 치킨집의 위치를 리스트에 저장
		houses = new ArrayList<>();
		chickens = new ArrayList<>();
		
		// 입력값 받기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int value = Integer.parseInt(st.nextToken());
				city[i][j] = value;
				if (value == 1) {
					houses.add(new int[]{i, j});
				} else if (value == 2) {
					chickens.add(new int[]{i, j});
				}
			}
		}
		
		// 치킨집 중 M개 선택
		selectChick = new ArrayList<>();
		combi(0,0);
		
		System.out.println(minChickenDistance);
		
 	}

	private static void combi(int depth, int start) {
		if (M == depth) { // 기저 조건 : M개의 치킨집을 모두 선택할 때
			// 여기에서 집 ~ 치킨집 거리 계산
			int totalChickenDistance = 0;
			for (int i = 0; i < houses.size(); i++) {
				int minDistance = Integer.MAX_VALUE;
				for (int j = 0; j < M; j++) {
					// 한 집과 치킨집들 간에 최소거리 -> 치킨거리 구함
					int a = Math.abs(houses.get(i)[0] - selectChick.get(j)[0]);
					int b = Math.abs(houses.get(i)[1] - selectChick.get(j)[1]);
					minDistance = Math.min(minDistance, a+b);
				}
				// 모든 집을 돌면서 치킨 거리 합 구함.
				totalChickenDistance += minDistance;
			}	
			minChickenDistance = Math.min(minChickenDistance, totalChickenDistance); 
			return;
		} 
		
		for (int i = start; i < chickens.size(); i++) {
			selectChick.add(chickens.get(i));
			combi(depth + 1, i + 1);
			selectChick.remove(selectChick.size() - 1);
		}
		
	}

}