class Solution {
    int[][] dp;
    public int getMoneyAmount(int n) {
        dp = new int[n + 1][n + 1];
        return minimax(1, n);
    }

    public int minimax(int start, int end) {
        if(start >= end) return 0;

        if(dp[start][end] != 0) return dp[start][end];
        int min = Integer.MAX_VALUE;

        for(int i = (start + end) / 2; i <= end; i++) {
            int left = minimax(start, i - 1);
            int right = minimax(i + 1, end);
            min = Math.min(i + Math.max(left, right), min);
        }
        return (dp[start][end] = min);
    }
}