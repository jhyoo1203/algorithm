import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> scoreMap = new HashMap<>();
        
        for (int i = 0; i < name.length; i++) {
            scoreMap.put(name[i], yearning[i]);
        }
        
        return Arrays.stream(photo)
            .mapToInt(persons -> Arrays.stream(persons)
                .mapToInt(person -> scoreMap.getOrDefault(person, 0))
                .sum()
            )
            .toArray();
    }
}