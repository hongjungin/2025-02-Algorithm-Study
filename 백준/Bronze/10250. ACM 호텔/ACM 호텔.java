import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int T = Integer.parseInt(br.readLine());
         StringBuilder sb = new StringBuilder();
         for (int i = 0; i < T; i++) {
             String[] tokens = br.readLine().split(" ");
             int H = Integer.parseInt(tokens[0]);
             int W = Integer.parseInt(tokens[1]);
             int N = Integer.parseInt(tokens[2]);
             int floor = N % H;
             int roomIndex = N / H;
             if(floor == 0) {
                 floor = H;
                 roomIndex--;
             }
             int roomNumber = floor * 100 + (roomIndex + 1);
             sb.append(roomNumber).append("\n");
         }
         System.out.print(sb.toString());
    }
}
