import java.util.*;

// 전체 스테이지 N
// 스테이지 배열을 정렬하는 문제
// 실패율 기준 내림차순
// 실패율이 같으면 작은 번호 스테이지
// 스테이지에 도달한 유저가 없으면 실패율 0

class Solution {
    
    static class StageData {
        int stageNum;
        double failureRate;
    
        public StageData(int stageNum, double failureRate) {
            this.stageNum = stageNum;
            this.failureRate = failureRate;
        }
    }
    
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] s = new int[N + 2];
        
        for (int i = 0; i < stages.length; i++) {
            int stageNum = stages[i];
            s[stageNum]++;
        }
        
        List<StageData> list = new ArrayList<>();
        int total = stages.length;
        for (int i = 1; i < N + 1; i++) {
            
            if (total == 0) {
                list.add(new StageData(i, 0));
            } else {
                double rate = (double) s[i] / total;
                total -= s[i];
                
                list.add(new StageData(i, rate));
            }
        }
        
        Collections.sort(list, (o1, o2) -> {
            if (o1.failureRate != o2.failureRate) {
                // 실패율 높은 거 부터 내림차순
                return Double.compare(o2.failureRate, o1.failureRate);
            }
            
            // 작은 번호 먼저 -> 오름차순
            return Integer.compare(o1.stageNum, o2.stageNum);
        });
        
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).stageNum;
        }
        
        return answer;
    }
}