class Solution {
    public int triangularSum(int[] nums) {
        int size = nums.length;
        int[] newnums = new int[size - 1];

        while(size > 1) {
            for(int i = 0; i < size - 1; i++) {
                newnums[i] = (nums[i] + nums[i+1]) % 10;
            }
            size--;
            nums = newnums;
        }
        return nums[0];
    }
}