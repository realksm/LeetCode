class Solution {
    class Pair {
        int row;
        int col;
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public int numIslands(char[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int ans = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(!vis[i][j] && grid[i][j] == '1') {
                    ans++;
                    bfs(grid, i, j, vis);
                }
            }
        }
        return ans;
    }
    public void bfs(char grid[][], int i, int j, boolean[][] vis) {
        vis[i][j] = true;
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(i, j));
        int n = grid.length;
        int m = grid[0].length;

        while(!q.isEmpty()) {
            int row = q.peek().row;
            int col = q.peek().col;
            q.remove();
            int nr = row - 1;
            int nc = col;
            if(nr >= 0 && nr < n && nc >= 0 && nc < m
               && grid[nr][nc] == '1' && !vis[nr][nc]) {
                vis[nr][nc] = true;
                q.add(new Pair(nr, nc));
            }
            nr = row + 1;
            nc = col;
            if(nr >= 0 && nr < n && nc >= 0 && nc < m
               && grid[nr][nc] == '1' && !vis[nr][nc]) {
                vis[nr][nc] = true;
                q.add(new Pair(nr, nc));
            }
            nr = row;
            nc = col - 1;
            if(nr >= 0 && nr < n && nc >= 0 && nc < m
               && grid[nr][nc] == '1' && !vis[nr][nc]) {
                vis[nr][nc] = true;
                q.add(new Pair(nr, nc));
            }
            nr = row;
            nc = col + 1;
            if(nr >= 0 && nr < n && nc >= 0 && nc < m
               && grid[nr][nc] == '1' && !vis[nr][nc]) {
                vis[nr][nc] = true;
                q.add(new Pair(nr, nc));
            }
        }
    }
}