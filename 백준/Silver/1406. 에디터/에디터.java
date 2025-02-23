import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;
import java.io.IOException;

public class Main {
	static String str;
	static LinkedList<Character> list;
	static ListIterator<Character> iter;
	static int T;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        str = br.readLine();
        list = new LinkedList<Character>();
        
        // 초기 문자열을 연결 리스트에 추가
        for(int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
        }
        
        // 리스트 iterator 사용
        iter = list.listIterator();
        // 커서를 문자열 맨 뒤로 이동
        while(iter.hasNext()) {
            iter.next();
        }
        
        T = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < T; i++) {
            String command = br.readLine();
            char c = command.charAt(0);
            
            switch(c) {
                case 'L':
                    if(iter.hasPrevious()) iter.previous();
                    break;
                    
                case 'D':
                    if(iter.hasNext()) iter.next();
                    break;
                    
                case 'B':
                    if(iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                    break;
                    
                case 'P':
                    char t = command.charAt(2);
                    iter.add(t);
                    break;
            }
        }
        
        for(Character ch : list) {
            bw.write(ch);
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}