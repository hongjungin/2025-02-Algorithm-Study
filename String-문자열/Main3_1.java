import java.util.Scanner;

class Main3_1 {
    public String solution(String str){
        String answer = "";
        int m = Integer.MIN_VALUE, pos;

        // indexOf(' ')로 공백이 있을 그때의 인덱스를 pos에 넘겨줌.
        while ((pos = str.indexOf(' ')) != -1) {
            // substring 으로 공백전까지 문자열을 tmp에 저장.
            String tmp = str.substring(0, pos);
            // 그 단어의 길이 len 구함.
            int len = tmp.length();
            // >= 이 안되는 이유 : 두 단어가 같은 길이이고 그 길이가 최댓값일 때
            // 앞 단어가 answer에 넘겨져야하므로 len > m
            if (len > m) {
                m = len;
                answer = tmp;
            }
            // 단어 떼어내고 다시 문자열 만듦.
            str = str.substring(pos + 1);
        }
        // 이걸 해주는 이유는 위에까지 코드가 실행되면
        // 마지막 단어가 str에 담기고 뒤에 문자열이 없으므로
        // 비교하지도 못한 채 -1이어서 while 문 밖으로 나감.
        // 따라서 마지막 단어까지 검사해주는 것임.
        if (str.length() > m) answer = str;

        return answer;
    }

    public static void main(String[] args) {
        Main3_1 T = new Main3_1();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.println(T.solution(str));
    }

}
