import java.util.*;

// 이름이 불리면 추월한 것
// players 배열 최대 길이 5만
// callings 배열 최대 길이 100만 -> 배열 다 돌면 시간 초과. 다른 자료구조 필요 

class Solution {
    public String[] solution(String[] players, String[] callings) {
        // 이름, 등수 같이 들고 다닐 수 있는 자료구조 -> HashMap
        HashMap<String, Integer> race = new HashMap<>();
        
        for (int i = 0; i < players.length; i++) {
            race.put(players[i], i + 1);
        }
        
        for (int i = 0; i < callings.length; i++) {
            int nowRank = race.get(callings[i]);
            // 불린 선수 rank 갱신
            race.put(callings[i], nowRank - 1);
            // 원래 앞에 선수 처리
            race.put(players[nowRank - 2], nowRank); // nowRank 가 1이 되는거 처리는 ..
            
            String temp = players[nowRank - 1];
            players[nowRank - 1] = players[nowRank - 2];
            players[nowRank - 2] = temp;
        }
        
        return players;
    }
}