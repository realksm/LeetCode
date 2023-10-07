class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int step = 0;
        int last_jump_max = 0;
        int curr_jump_max = 0;
        for(int i = 0; i < n - 1; i++) {
            curr_jump_max = Math.max(curr_jump_max, i + nums[i]);
            if(i == last_jump_max) {
                step++;
                last_jump_max = curr_jump_max;
            }
        }
        return step;
    }
}