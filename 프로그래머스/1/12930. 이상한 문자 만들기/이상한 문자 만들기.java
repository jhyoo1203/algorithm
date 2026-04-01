class Solution {
    public String solution(String s) {
        String[] parsed = s.split(" ", -1);
        
        StringBuilder sb = new StringBuilder();
        for (String p : parsed) {
            for (int i = 0; i < p.length(); i++) {
                String temp = String.valueOf(p.charAt(i));
                if (i % 2 == 0) sb.append(temp.toUpperCase());
                else sb.append(temp.toLowerCase());
            }
            sb.append(" ");
        }
        
        sb.deleteCharAt(s.length());
        
        return sb.toString();
    }
}