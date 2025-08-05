class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length, m = image[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});
        int point = image[sr][sc];
        image[sr][sc] = color;
        vis[sr][sc] = true;

        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, 1, -1};
        
        while(!q.isEmpty()) {
            int r = q.peek()[0];
            int c = q.poll()[1];

            for(int k = 0; k < 4; k++) {
                int nr = r + dy[k];
                int nc = c + dx[k];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m && image[nr][nc] == point && !vis[nr][nc]) {
                    q.add(new int[]{nr, nc});
                    image[nr][nc] = color;
                    vis[nr][nc] = true;
                }
            }
        }
        return image;
    }
}