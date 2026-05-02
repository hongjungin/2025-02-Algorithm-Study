import java.util.*;

class Solution {
    
    static class Info {
        int id;
        String genres;
        int plays;
        
        public Info (int id, String genres, int plays) {
            this.id = id;
            this.genres = genres;
            this.plays = plays;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String, Integer> song = new HashMap<>();
        
        for (int i = 0; i < plays.length; i++) {
            song.put(genres[i], song.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        List<Info> list = new ArrayList<>();
        for (int i = 0; i < plays.length; i++) {
            list.add(new Info(i, genres[i], plays[i]));
        }
        
        Collections.sort(list, (o1, o2) -> {
            // 장르 기준
            if (song.get(o1.genres) != song.get(o2.genres)) {
                return Integer.compare(song.get(o2.genres), song.get(o1.genres));
            }
            
            // 장르 총합이 같아?
            if (o1.plays != o2.plays) {
                return Integer.compare(o2.plays, o1.plays);
            }
            
            // 개별 재생 횟수가 같아?
            return Integer.compare(o1.id, o2.id);
        });
        
        // 이제 갯수 카운트
        Map<String, Integer> countMap = new HashMap<>();
        List<Integer> resultList = new ArrayList<>();
        
        for (int i = 0; i < plays.length; i++) {
            countMap.put(list.get(i).genres, countMap.getOrDefault(list.get(i).genres, 0) + 1);
            
            if (countMap.get(list.get(i).genres) <= 2) {
                resultList.add(list.get(i).id);
            }
        }
        
        int[] answer = new int[resultList.size()];
        
        for (int i = 0; i < resultList.size(); i++) {
            answer[i] = resultList.get(i);
        }
        
        return answer;
    }
}