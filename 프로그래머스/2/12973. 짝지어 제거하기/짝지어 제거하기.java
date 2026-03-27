import java.util.*;

class Solution
{
    public int solution(String s)
    {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        int answer;
        
        char[] str = s.toCharArray();
        
        for (char c : str) {
            if (!stack.isEmpty() && c == stack.peek()) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        
        if (stack.isEmpty()) {
            answer = 1;
        } else {
            answer = 0;
        }
        
        return answer;
    }
}