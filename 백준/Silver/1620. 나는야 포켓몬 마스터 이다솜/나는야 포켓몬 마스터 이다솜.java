import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); 
        int M = Integer.parseInt(st.nextToken()); 

        HashMap<String, Integer> nameToNum = new HashMap<>();
        ArrayList<String> numToName = new ArrayList<>(N + 1);
        numToName.add(""); 

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            nameToNum.put(name, i);  
            numToName.add(name);    
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String query = br.readLine();
            if (Character.isDigit(query.charAt(0))) {
                sb.append(numToName.get(Integer.parseInt(query))).append("\n");
            } else {
                sb.append(nameToNum.get(query)).append("\n");
            }
        }

        System.out.print(sb); 
    }
}
