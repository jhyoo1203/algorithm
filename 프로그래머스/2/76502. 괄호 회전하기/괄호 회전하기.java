import java.util.*;

class Solution {
    public int solution(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        
        int n = s.length();
        s += s;
        int cnt = 0;
        
        outerLoop:
        for (int i = 0; i < n; i++) {
            for (int j = i; j < i+n; j++) {
                char c = s.charAt(j);
                if (!map.containsKey(c)) {
                    stack.push(c);
                } else {
                    if(stack.isEmpty() || !stack.pop().equals(map.get(c)))
                        continue outerLoop;
                }
            }
            if (stack.isEmpty())
                cnt++;
        }
        
        
        return cnt;
    }
}