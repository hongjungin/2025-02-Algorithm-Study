import java.util.*;

class Shinhan02 {

    static class Info {
        int id;
        int priority;
        int expected;

        public Info(int id, int priority, int expected) {
            this.id = id;
            this.priority = priority;
            this.expected = expected;
        }
    }

    public long[] solution(int[][] expected_scores, int[][] actual_scores, int k) {
        long[] answer = new long[2];

        Map<Integer, Integer> actualMap = new HashMap<>();
        for (int i = 0; i < actual_scores.length; i++) {
            actualMap.put(actual_scores[i][0], actual_scores[i][1]);
        }

        List<Info> list = new ArrayList<>();
        for (int i = 0; i < expected_scores.length; i++) {
            list.add(new Info(expected_scores[i][0], expected_scores[i][1], expected_scores[i][2]));
        }

        Collections.sort(list, (o1, o2) -> {
           // 오름차순
           return Integer.compare(o1.priority, o2.priority);
        });
        long expectedScore = 0L;
        long actualScore = 0L;
        for (int i = 0; i < k; i++) {
            expectedScore += list.get(i).expected;
            actualScore += (long)actualMap.get(list.get(i).id);
        }

        answer[0] = Math.abs(expectedScore - actualScore);

        Collections.sort(list, (o1, o2) -> {
           if (o1.expected != o2.expected) {
               return Integer.compare(o2.expected, o1.expected);
           }

           return Integer.compare(o1.priority, o2.priority);
        });
        expectedScore = 0L;
        actualScore = 0L;
        for (int i = 0; i < k; i++) {
            expectedScore += list.get(i).expected;
            actualScore += (long)actualMap.get(list.get(i).id);
        }

        answer[1] = Math.abs(expectedScore - actualScore);

        return answer;
    }
}
