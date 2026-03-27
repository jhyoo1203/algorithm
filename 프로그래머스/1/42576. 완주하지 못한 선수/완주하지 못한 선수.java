import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> people = new HashMap<>();
        
        for (String p : participant) {
            people.put(p, people.getOrDefault(p, 0) + 1);
        }
        
        for (String c : completion) {
            people.put(c, people.get(c) - 1);
        }
        
        for (String p : people.keySet()) {
            if (people.get(p) != 0) {
                return p;
            }
        }
        
        return null;
    }
}