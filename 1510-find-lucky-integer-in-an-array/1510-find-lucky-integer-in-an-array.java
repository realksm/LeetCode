class Solution {
    public int findLucky(int[] arr) {
        int[] count = new int[501];
        int max = 0;
        for (int num : arr) {
            count[num]++;
            max = Math.max(max, num);
        }
        for (int i = max; i > 0; i--) {
            if (count[i] == i)
                return i;
        }
        return -1;
    }
}