import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new ArrayDeque<>();
        
        int n = progresses.length;
        int[] deploy = new int[n];
        
        for (int i = 0; i < n; i++) {
            deploy[i] = (int)Math.ceil((100.0 - progresses[i]) / speeds[i]);
        }
        
        int cnt = 0;
        int max = deploy[0];
        
        for (int i = 0; i < n; i++) {
            if (deploy[i] <= max) {
                cnt++;
            } else {
                q.add(cnt);
                cnt = 1;
                max = deploy[i];
            }
        }
        q.add(cnt);
        
        return q.stream().mapToInt(Integer::intValue).toArray();
    }
}