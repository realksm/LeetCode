class Solution {
    public int findClosest(int x, int y, int z) {
        return Math.abs(z - x) < Math.abs(z - y) ? 1 : Math.abs(z - x) == Math.abs(z - y) ? 0 : 2;
    }
}