import java.util.Scanner;

public class B1152 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim();

//        char[] c = input.toCharArray();
//        int count = 0;
//        for (int i = 0; i < c.length; i++) {
//            if (c[i] == ' '){
//                count++;
//            }
//        }
//        System.out.println(count + 1);

        // 내가 생각하지 못한 부분 -> 단어와 단어 사이에 공백이 2개 이상이면?

        if (input.isEmpty()){
            System.out.println(0);
        }else {
            String[] words = input.split("\\s+");
            System.out.println(words.length);
        }
    }
}
