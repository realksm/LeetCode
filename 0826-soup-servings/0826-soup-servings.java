class Solution {
    private double[][] memo;
    public double soupServings(int n) {
        memo = new double[4000][4000];
        return n >= 4300 ? 1 : dfs((n + 24)/25, (n + 24)/25);
    }

    private double dfs(int a, int b) {
        if(a <= 0 && b <= 0) return 0.5;
        if(a <= 0) return 1.0;
        if(b <= 0) return 0.0;

        if(memo[a][b] > 0) return memo[a][b];

        return memo[a][b] = 0.25 * (dfs(a - 1, b - 3) + dfs(a - 2, b - 2) + dfs(a - 3, b - 1) + dfs(a - 4, b));
    }
}