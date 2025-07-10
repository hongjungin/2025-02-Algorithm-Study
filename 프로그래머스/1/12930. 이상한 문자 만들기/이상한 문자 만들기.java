import java.util.Arrays;

class Solution {
    public String solution(String s) {
        char[] arr = s.toCharArray();
        //System.out.println(Arrays.toString(arr));
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                index = 0;
                continue;
            }
            if (index % 2 == 0) { // 짝수 인덱스 일 때 
                arr[i] = Character.toUpperCase(arr[i]);
                index++;
            } else {
                arr[i] = Character.toLowerCase(arr[i]);
                index++;
            }
        }
        
        String answer = "";
        answer = new String(arr);
        return answer;
    }
}