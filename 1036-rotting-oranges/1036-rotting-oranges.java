class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        int cntFresh = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 2) {
                    q.add(new int[]{i,j,0});
                    vis[i][j] = true;
                }
                if(grid[i][j] == 1) cntFresh++;
            }
        }

        int tm = 0;
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        int cnt = 0;
        while(!q.isEmpty()) {
            int r = q.peek()[0];
            int c = q.peek()[1];
            int t = q.poll()[2];
            tm = Math.max(tm, t);
            for(int k = 0; k < 4; k++) {
                int nr = r + dy[k];
                int nc = c + dx[k];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1 && !vis[nr][nc]) {
                    q.add(new int[]{nr, nc, t + 1});
                    vis[nr][nc] = true;
                    cnt++;
                }
            }
        }
        if(cnt != cntFresh) return -1;
        return tm;
    }
}