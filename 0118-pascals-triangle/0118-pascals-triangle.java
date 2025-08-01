class Solution {
    public List<List<Integer>> generate(int numRows) {
        int[][] ans = new int[numRows][];
        for(int i = 0; i < numRows; i++) {
            int[] row = new int[i+1];
            row[0] = 1;
            row[i] = 1;
            for(int j = 1; j < i; j++) {
                row[j] = ans[i-1][j-1] + ans[i-1][j];
            } 
            ans[i] = row;
        }
        return (List) Arrays.asList(ans);
    }
}