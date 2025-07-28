class Solution {
    public int[] applyOperations(int[] nums) {
        int[] res = new int[nums.length];
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                if(i + 1 < nums.length && nums[i] == nums[i + 1]) {
                    res[j] = nums[i] * 2;
                    i++;
                } else {
                    res[j] = nums[i];
                }
                j++;
            }
        }

        return res;
    }
}