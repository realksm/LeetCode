class Solution {
    public String orderlyQueue(String s, int k) {
        if(k > 1){
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            return new String(ch);
        }

        StringBuilder sb = new StringBuilder(s + s);
        String best = s;

        for(int i = 0; i < s.length(); i++) {
            String news = sb.substring(i, s.length() + i);
            if(news.compareTo(best) < 0) best = news; 
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