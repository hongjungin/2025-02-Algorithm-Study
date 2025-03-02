import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        double A = Double.parseDouble(input[0]);
        double B = Double.parseDouble(input[1]);
        System.out.println(A / B);
    }
}
