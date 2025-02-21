import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int H,W;
	static int N;
	static int[] num;
	static int target;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		num = new int[N+1];
		
		for(int i=0;i<N+1;i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(r==1) num[i] = c;
			else if(r==2) num[i] = (2*H + W - c);
			else if(r==3) num[i] = (2*H + 2*W - c);
			else if(r==4) num[i] = (H+c);
		}
		
		//System.out.println(Arrays.toString(num));
		
		int sum = 0;
		
		for(int i=0;i<N;i++) {
			sum += Math.min(Math.abs(num[i]-num[num.length-1]) 
					, Math.abs((2*H+2*W) -Math.abs(num[i]-num[num.length-1]) ) );
		}
		System.out.println(sum);
	}

}
