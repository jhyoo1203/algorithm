import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        ArrayDeque stack = new ArrayDeque<>();
        
        for (int move : moves) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][move - 1] != 0) {
                    if (!stack.isEmpty() && board[j][move - 1] == (int) stack.peek()) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(board[j][move - 1]);
                    }
                    
                    board[j][move - 1] = 0;
                    break;
                }
            }
        }
        
        
        return answer;
    }
}