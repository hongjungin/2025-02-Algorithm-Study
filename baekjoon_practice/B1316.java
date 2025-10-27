import java.util.*;
import java.io.*;

// 연속해서 나오면 그룹 단어
// 그 그룹의 개수
// 각 단어마다 저장하기 때문에 저장하는 자료형은 문자열 배열도 괜찮을 듯
// 같은 게 나오다가 다른 단어가 나오면 그 순간 그룹 단어가 아니잖아
// 그럼 방문 체크를 해야하나. charArray두고?
public class B1316 {
    static int N, groupCnt;
    static String[] input;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        input = new String[N];
        for (int i = 0; i < N; i++) {
            input[i] = br.readLine();
        }

        groupCnt = 0;

        for (int i = 0; i < N; i++) {
            boolean[] visited = new boolean[26];
            char prev = input[i].charAt(0);
            char cur = ' ';
            for (char c : input[i].toCharArray()) {
                // 여기서 막히는거 이전거랑 그 다음거랑 비교를 어떻게 하지
                // cur prev 두고 비교 !
                cur = c;
                //
                if(prev == cur) {
                    visited[cur - 'a'] = true;
                    prev = cur;
                    continue;
                } // 달라 근데 이미 찍은거야. -> 그룹 단어 아님
                else if (prev != cur && visited[cur -'a']) break;
            }
        }

        System.out.println(N - groupCnt);
    }
}

