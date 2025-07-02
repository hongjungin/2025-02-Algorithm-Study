import java.util.Scanner;

class Main19 {
    public String solution(String str){
        String answer = "";
        String[] arr = str.split("\\s+");
        int max = 0;
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            int len = arr[i].length();
//            System.out.println("현재 길이" + " " + len);
            if (len > max) {
                max = len;
//                System.out.println("max" + max);
                index = i;
            }
        }

        answer = arr[index];
        return answer;
    }

    public static void main(String[] args) {
        Main19 T = new Main19();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.println(T.solution(str));
    }

}