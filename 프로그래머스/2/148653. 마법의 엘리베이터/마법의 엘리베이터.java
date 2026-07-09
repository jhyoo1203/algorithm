class Solution {
    public int solution(int storey) {
        int count = 0;
        
        while (storey != 0) {
            int digit = storey % 10;
            if (digit >= 6 && digit <= 9) {
                int target = 10 - digit;
                count += target;
                storey += 10;
            } else if (digit >= 0 && digit <= 4) {
                count += digit;
            }
            else {
                int nextDigit = (storey / 10) % 10;
                
                if (nextDigit >= 5) {
                    int target = 10 - digit;
                    count += target;
                    storey += target;
                } else {
                    count += digit;
                }
            }
            storey /= 10;
        }
        
        return count;
    }
}