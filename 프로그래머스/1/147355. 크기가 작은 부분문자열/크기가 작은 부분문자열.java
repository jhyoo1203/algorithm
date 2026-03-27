class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int pLength = p.length();
        long pLong = Long.parseLong(p);
        for (int i = 0; i < t.length() - pLength + 1; i++) {
            String tSubstring = t.substring(i, i + pLength);
            
            if (Long.parseLong(tSubstring) <= pLong) {
                answer++;
            } 
        }
        return answer;
    }
}