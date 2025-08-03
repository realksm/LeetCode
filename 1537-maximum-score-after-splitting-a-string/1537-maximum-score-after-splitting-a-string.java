class Solution {
    public int maxScore(String s) {
        int ans = 0;
        if(s.charAt(0) == '0') ans += 1;
        for(int i = 1; i < s.length(); i++) if(s.charAt(i) == '1') ans += 1;

        int max = ans;
        for(int i = 1; i < s.length() - 1; i++) {
            ans += s.charAt(i) == '0' ? 1 : -1;
            max = Math.max(max, ans);
        }
        return max;
    }
}