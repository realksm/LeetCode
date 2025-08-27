class Solution {
    private static final int[][] dirs = { { 1, 1 }, { 1, -1 }, { -1, -1 }, { -1, 1 } };
    public int lenOfVDiagonal(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][][] memo = new int[m][n][1 << 3];
        int ans = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] != 1) {
                    continue;
                }
                for(int k = 0; k < 4; k++) {
                    ans = Math.max(ans, dfs(i, j, k, 1, 2, grid, memo) + 1);
                }
            }
        }
        return ans;
    }

    private int dfs(int i ,int j, int k, int canTurn, int target, int[][] grid, int[][][] memo) {
        i += dirs[k][0];
        j += dirs[k][1];
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != target) {
            return 0;
        }
        int mask = k << 1 | canTurn;
        if(memo[i][j][mask] > 0) return memo[i][j][mask];

        int res = dfs(i, j, k, canTurn, 2 - target, grid, memo);
        if(canTurn == 1) {
            k = (k + 1) % 4;
            res = Math.max(res, dfs(i, j, k, 0, 2 - target, grid, memo));
        } 
        return memo[i][j][mask] = res + 1;
    }
}