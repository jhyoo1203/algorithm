import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int sec = prices.length;
        int[] answer = new int[sec];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        stack.push(0);
        
        for (int i = 1; i < sec; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int j = stack.pop();
                answer[j] = i - j;
            }
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            int i = stack.pop();
            answer[i] = sec - 1 - i;
        }
        
        return answer;
    }
}