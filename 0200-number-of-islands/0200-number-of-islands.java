class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1' && !vis[i][j]) {
                    ans++;
                    bfs(grid, i, j, vis);
                }
            }
        }
        return ans;
    }
    public void bfs(char[][] grid, int i, int j, boolean[][] vis) {
        vis[i][j] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        int n = grid.length;
        int m = grid[0].length;
        while(!q.isEmpty()) {
            int row = q.peek()[0];
            int col = q.poll()[1];

            for(int k = 0; k < 4; k++) {
                int nr = row + dy[k];
                int nc = col + dx[k];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == '1' && !vis[nr][nc]) {
                    vis[nr][nc] = true;
                    q.add(new int[]{nr,nc});
                }
            }
        }
    }
}