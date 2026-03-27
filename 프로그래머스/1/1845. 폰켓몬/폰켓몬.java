import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums) {
            set.add(num);
        }
        
        int len = nums.length / 2;

        return Math.min(len, set.size());
    }
}