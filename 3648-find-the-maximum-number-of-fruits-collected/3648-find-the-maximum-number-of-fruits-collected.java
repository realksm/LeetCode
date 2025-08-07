class Solution {
    private int n;
    private int[][] memo;
    private int[][] dirs;
    private int[][] fruits;
    public int maxCollectedFruits(int[][] fruits) {
        this.n = fruits.length;
        this.fruits = fruits;

        int first = 0;
        for(int i = 0; i < n; i++) first += fruits[i][i];

        this.memo = new int[n][n];
        for(int[] m : memo) Arrays.fill(m, -1);

        dirs = new int[][]{ 
            {1, -1},
            {1, 0},
            {1, 1}
         };

        int second = dfs(0, n - 1, n - 1);

        this.memo = new int[n][n];
        for(int[] m : memo) Arrays.fill(m, -1);

        dirs = new int[][]{ 
            {-1, 1},
            {0, 1},
            {1, 1}
         };

        int third = dfs(n - 1, 0, n - 1);

        return first + second + third;
    }

    private int dfs(int row, int col, int moves) {
        if(row == n - 1 && col == n - 1) {
            return (moves == 0) ? 0 : Integer.MAX_VALUE;
        }

        if(moves == 0 || row == col) {
            return Integer.MAX_VALUE;
        }

        if(memo[row][col] != -1) return memo[row][col];

        long best = -1;
        for(int[] dir : dirs) {
            int nr = row + dir[0], nc = col + dir[1];
            if(nr >= 0 && nr < n && nc >= 0 && nc < n) {
                int val = dfs(nr, nc, moves - 1);
                if(val != Integer.MAX_VALUE) {
                    best = Math.max(best, val);
                }
            }
        }
        memo[row][col] = best < 0 ? Integer.MAX_VALUE : (int) best + fruits[row][col];
        return memo[row][col];
    }
}