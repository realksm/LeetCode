class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        boolean[] vis = new boolean[n];
        int unplaced = n;

        for(int f : fruits) {
            for(int i = 0; i < n; i++) {
                if(baskets[i] >= f && !vis[i]) {
                    vis[i] = true;
                    --unplaced;
                    break;
                }
            }
        }

        return unplaced;
    }
}