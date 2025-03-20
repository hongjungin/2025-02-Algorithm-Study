import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 참가자 수 N 입력
        int N = Integer.parseInt(br.readLine());
        
        // 티셔츠 사이즈별 신청자 수 입력
        int[] sizes = new int[6];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            sizes[i] = Integer.parseInt(st.nextToken());
        }
        
        // 티셔츠 묶음 수 T와 펜 묶음 수 P 입력
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        
        // 티셔츠 최소 묶음 수 계산
        int totalBundles = 0;
        for (int size : sizes) {
            totalBundles += (size + T - 1) / T; // 올림 계산
        }
        
        // 펜 묶음 수 및 낱개 수 계산
        int penBundles = N / P;
        int remainingPens = N % P;
        
        // 결과 출력
        System.out.println(totalBundles);
        System.out.println(penBundles + " " + remainingPens);
    }
}
