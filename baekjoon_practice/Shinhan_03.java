import java.util.*;

class Shinhan_03 {

    public int solution(String[] A, String[] B) {
        int n = A.length;
        int answer = 0;

        // 1. [데이터 세팅]
        // 중복이 없을 때
        Map<String, Integer> AMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            AMap.put(A[i], i);
        }

        // 2. [순회 및 비교]
        int currentLength = 1;
        for (int i = 0; i < 2 * n - 1; i++) {
            int cur = i % n;
            int next = (i + 1) % n;

            int posCur = AMap.get(B[cur]);
            int posNext = AMap.get(B[next]);

            if ((posNext - posCur + n) % n == 1) {
                currentLength++;
            } else {
                currentLength = 1;
            }
        }

        return currentLength;
    }
}
