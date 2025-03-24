import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String id = sc.next();  // 사용자로부터 아이디 입력 받기
        System.out.println(id + "??!");  // 아이디 뒤에 "??!" 붙여 출력
        sc.close();
    }
}
