class Solution {
    public int maxSum(int[] nums) {
        boolean[] ifPresent = new boolean[101];
        int sum = 0, flag = -1;
        int max = -101;
        for(int i : nums) {
            if(i >= 0 && !ifPresent[i]) {
                flag = 0;
                sum += i;
                ifPresent[i] = true;
            }
            if(i < 0) {
                max = Math.max(max, i);
            }
        }
        return flag == 0 ? sum : max;
    }
}