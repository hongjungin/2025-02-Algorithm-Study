import java.util.Scanner;

public class Solution {
	static int T, N;
	static int dr[] = {0, 1, 0, -1};
	static int dc[] = {1, 0, -1, 0};
	static int arr[][];
	static int num;
	static int mr, mc;
	static int repeat;
	static int j;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for (int t = 0; t < T; t++) {
			N = sc.nextInt();
			repeat = N;
			arr = new int[N][N];
			mr = 0;
			mc = -1;
			j = 0;
			num = 0;
			
			a: while (num <= N * N) {
				for (int k = 0; k < repeat; k++) {
					mr = mr + dr[j];
					mc = mc + dc[j];
					arr[mr][mc] = ++num;
					if(num == N * N) {
						break a;
					}
				}
				
				j++;
				if (j == 4) {
					j = 0;
				}
				
				if (j % 2 == 1) {
					repeat--;
				}
			}
			
			System.out.printf("#%d\n", t + 1);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
