class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) return 1;
        int n = s.length();

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for(int i = 2; i <= n; i++) {
            int one = s.charAt(i - 1) - '0';
            int two = 10 * (s.charAt(i - 2) - '0') + one;
            if(one >= 1 && one <= 9) dp[i] += dp[i - 1];
            if(two >= 10 && two <= 26) dp[i] += dp[i - 2];
        }
        return dp[n];
    }
}