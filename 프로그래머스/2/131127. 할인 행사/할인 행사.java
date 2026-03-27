import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        HashMap<String, Integer> products = new HashMap<>();
        int answer = 0;
        
        for (int i = 0; i < want.length; i++) {
            products.put(want[i], number[i]);
        }
        
        for (int i = 0; i < discount.length - 9; i++) {
            HashMap<String, Integer> discountMap = new HashMap<>();
            
            for (int j = i; j < i + 10; j++) {
                if (products.containsKey(discount[j])) {
                    discountMap.put(discount[j], discountMap.getOrDefault(discount[j], 0) + 1);
                }
            }
            
            if (discountMap.equals(products))
                answer++;
        }
        
        return answer;
    }
}