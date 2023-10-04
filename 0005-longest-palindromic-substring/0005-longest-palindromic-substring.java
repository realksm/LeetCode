class Solution {
    public String longestPalindrome(String s) {
        if(s.length() <= 1) return s;

        int len = s.length();

        boolean[][] dp = new boolean[len][len];

        for(int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        int maxlen = 0, start = 0, end = 0;

        for(int i = len; i >= 0; i--) {
            for(int dist = 1; dist < len - i; dist++) {
                int j = i + dist;
                if(dist == 1 && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                } else if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                }

                if(dp[i][j] && maxlen < (j - i + 1)) {
                    maxlen = j - i + 1;
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start, end + 1);
    }
}