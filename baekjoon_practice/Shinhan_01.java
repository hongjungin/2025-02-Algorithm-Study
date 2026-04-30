import java.util.*;

public class Shinhan_01 {

    public int solution(int[] data) {
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        boolean hasNegative = false;

        for (int i = 0; i < data.length; i++) {
            if (data[i] < min) min = data[i];
            if (data[i] > max) max = data[i];
            if (data[i] < 0) hasNegative = true;
        }

        int k = 1;

        while (true) {
            if (hasNegative) {
                // 최소 범위: -2^(k-1)
                long minLimit = -(1L << (k-1));
                // 최대 범위: 2^(k-1) - 1
                long maxLimit = (1L << (k-1)) - 1;

                if (min >= minLimit && max <= maxLimit) {
                    break;
                }
            } else {
                long maxLimit = (1L << (k - 1)) -1;

                if (max <= maxLimit) {
                    break;
                }
            }

            k++;
        }

        return k;
    }
}
