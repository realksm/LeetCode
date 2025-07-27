class Solution {
    public String orderlyQueue(String s, int k) {
        if(k > 1){
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            return new String(ch);
        }

        StringBuilder sb = new StringBuilder(s);
        sb.append(sb.charAt(0));
        sb.deleteCharAt(0);
        
        String best = s;
        while(!sb.toString().equals(s)) {
            if(findBest(best, sb.toString())) best = sb.toString();
            sb.append(sb.charAt(0));
            sb.deleteCharAt(0);
        }

        return best;
    }

    private boolean findBest(String best, String s) {
        int i = 0;
        while(best.charAt(i) == s.charAt(i)) {
            i++;
        }
        return best.charAt(i) > s.charAt(i);
    }
}