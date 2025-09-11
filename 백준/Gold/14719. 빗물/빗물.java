import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {

    static int H, W, rain, l_max, r_max;
    static int[] world;

    public static void main (String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        world = new int[W];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < W; i++) {
            world[i] = Integer.parseInt(st.nextToken());
        }

        rain = 0;
        l_max = world[0];
        r_max = world[W-1];

        int left = 0;
        int right = W - 1;

        while (left < right) {
            l_max = Math.max(world[left], l_max);
            r_max = Math.max(world[right], r_max);

            // 왼쪽 이동
            if (l_max <= r_max) {
                int r = l_max - world[left];
                if (r > 0) rain += r;
                left++;
            }

            // 오른쪽이 이동
            if (l_max > r_max) {
                int r = r_max - world[right];
                if (r > 0) rain += r;
                right--;
            }

        }
        System.out.println(rain);
    }
}
