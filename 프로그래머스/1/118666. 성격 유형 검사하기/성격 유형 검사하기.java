import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> mbti = new HashMap<>();
        
        for (int i = 0; i < survey.length; i++) {
            if (choices[i] > 0 && choices[i] < 4) {
                char ch = survey[i].charAt(0);
                mbti.put(ch, mbti.getOrDefault(ch, 0) + 4 - choices[i]);
            } else if (choices[i] > 4) {
                char ch = survey[i].charAt(1);
                mbti.put(ch, mbti.getOrDefault(ch, 0) + choices[i] - 4);
            }
        }
        
        return new StringBuilder()
            .append(mbti.getOrDefault('R', 0) >= mbti.getOrDefault('T', 0) ? 'R' : 'T')
            .append(mbti.getOrDefault('C', 0) >= mbti.getOrDefault('F', 0) ? 'C' : 'F')
            .append(mbti.getOrDefault('J', 0) >= mbti.getOrDefault('M', 0) ? 'J' : 'M')
            .append(mbti.getOrDefault('A', 0) >= mbti.getOrDefault('N', 0) ? 'A' : 'N')
            .toString();
    }
}