class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        final int MOD = (int) 1e9 + 7;
        if(n == 1) return 1;
        long[] dp = new long[n + 1];
        dp[1] = 1;
        long window = 0;
        for(int i = 2; i <= n; i++) {
            int getToKnow = i - delay;
            int getToForg = i - forget;
            if(getToKnow >= 1) window = (window + dp[getToKnow]) % MOD;
            if(getToForg >= 1) window = (window - dp[getToForg] + MOD) % MOD;
            dp[i] = window;
        }

        long ans = 0;
        int start = Math.max(1, n - forget + 1);
        for(int i = start; i <= n; i++) ans = (ans + dp[i]) % MOD;
        return (int) ans;
    }
}