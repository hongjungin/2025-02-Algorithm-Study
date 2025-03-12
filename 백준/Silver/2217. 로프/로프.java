//N개의 로프
//k개의 로프를 사용해 중량이 w인 물체를 들어올림

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
 static int N;
 static int[] rope;
 public static void main(String[] args) throws IOException {
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     
     N = Integer.parseInt(br.readLine());
     rope = new int[N];
     for (int i = 0; i < N; i++) {
         rope[i] = Integer.parseInt(br.readLine());
     }
     Arrays.sort(rope);
     int maxW = Integer.MIN_VALUE;
     for (int i = N - 1; i >= 0; i--) {
		int weight = rope[i] * (N - i);
		maxW = Math.max(maxW, weight);
	}
     
     System.out.println(maxW);
 }
}

