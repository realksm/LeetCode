class Solution {
    public int maxSum(int[] nums) {
        boolean[] ifPresent = new boolean[101];
        int sum = 0;
        boolean flag = false;
        int max = -101;
        for(int i : nums) {
            if(i >= 0 && !ifPresent[i]) {
                flag = true;
                sum += i;
                ifPresent[i] = true;
            }
            max = Math.max(max, i);
        }
        return flag ? sum : max;
    }
}