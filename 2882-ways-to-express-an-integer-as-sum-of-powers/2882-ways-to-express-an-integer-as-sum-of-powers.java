class Solution {
    public int numberOfWays(int n, int x) {
        int MOD = (int) 1e9 + 7;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        int ix;

        for(int i = 1; (ix = (int) Math.pow(i, x)) <= n; i++) {
            for(int j = n; j >= ix; j--) {
                dp[j] += dp[j - ix];
                dp[j] %= MOD;
            }
        }
        return dp[n];
    }
}

/**
    dp[0] = 1
    dp[1] = 1
    dp[2] = 1
    dp[3] = 2

 */    