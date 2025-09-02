class Solution {
    public int numberOfPairs(int[][] points) {
        Arrays.sort(points, (a, b) -> {
            return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
        });
        int count = 0;
        int n = points.length;

        for(int i = 0; i < n; i++) {
            int y1 = points[i][1];
            int yLimit = Integer.MIN_VALUE;
            for(int j = i + 1; j < n; j++) {
                int y2 = points[j][1];
                if(y2 <= y1 && y2 > yLimit) {
                    count++;
                    yLimit = y2;
                    if(y2 == y1) break;
                }
            }
        }
        return count;
    }
}