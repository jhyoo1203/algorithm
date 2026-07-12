import java.util.*;

class Solution {
    
    private static HashMap<String, Integer> map = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        for (int i = 0; i < orders.length; i++) {
            for (int j = 0; j < course.length; j++) {
                char[] charArray = orders[i].toCharArray();
                Arrays.sort(charArray);
                String sortedOrder = new String(charArray);
                combination(0, "", sortedOrder, course[j]);
            }
        }
        
        List<String> answer = new ArrayList<>();
        
        for (int c : course) {
            int max = 0;

            for (var entry : map.entrySet()) {
                if (entry.getKey().length() == c) {
                    max = Math.max(max, entry.getValue());
                }
            }

            if (max >= 2) { 
                for (var entry : map.entrySet()) {
                    if (entry.getKey().length() == c && entry.getValue() == max) {
                        answer.add(entry.getKey());
                    }
                }
            }
        }
        
        Collections.sort(answer);
        
        return answer.toArray(new String[0]);
    }
    
    private void combination(int start, String cur, String order, int targetLength) {
        if (cur.length() == targetLength) {
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }
        
        if (start >= order.length()) {
            return;
        }
        
        for (int i = start; i < order.length(); i++) {
            String next = cur + order.charAt(i);
            combination(i + 1, next, order, targetLength);
        }
    }
}