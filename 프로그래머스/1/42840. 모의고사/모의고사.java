import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] scores = new int[3];
        
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == one[i % one.length]) scores[0]++;
            if (answers[i] == two[i % two.length]) scores[1]++;
            if (answers[i] == three[i % three.length]) scores[2]++;
        }
        
        int max = Math.max(scores[0], Math.max(scores[1], scores[2]));
        
        if (scores[0] == max) answer.add(1);
        if (scores[1] == max) answer.add(2);
        if (scores[2] == max) answer.add(3);
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}