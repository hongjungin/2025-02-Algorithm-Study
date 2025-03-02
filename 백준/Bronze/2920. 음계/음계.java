import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        int[] arr = new int[8];
        for (int i = 0; i < 8; i++) {
            arr[i] = Integer.parseInt(tokens[i]);
        }
        boolean ascending = true;
        boolean descending = true;
        for (int i = 0; i < 7; i++) {
            if (arr[i] < arr[i + 1]) {
                descending = false;
            }
            if (arr[i] > arr[i + 1]) {
                ascending = false;
            }
        }
        if (ascending) {
            System.out.println("ascending");
        } else if (descending) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }
    }
}
