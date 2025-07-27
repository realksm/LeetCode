class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        return dfs(n, dp);
    }

    private int dfs(int n, int[] dp) {
        if(n <= 1) return (dp[n] = 1);

        if(dp[n] != 0) return dp[n];

        for(int i = 1; i <= n; i++) {
            int left = dfs(i - 1, dp);
            int right = dfs(n - i, dp);
            dp[n] += left * right;
        }

        return dp[n];
    }
}