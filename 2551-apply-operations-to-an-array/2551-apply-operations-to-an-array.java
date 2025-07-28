class Solution {
    public int[] applyOperations(int[] nums) {
        int[] res = new int[nums.length];
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i + 1 < nums.length && nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }

            if(nums[i] != 0) {
                res[j++] = nums[i];
            }
        }

        return res;
    }
}