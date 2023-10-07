class Solution {
    public boolean canJump(int[] nums) {
        int reach = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i > reach) return false;
            reach = Math.max(i + nums[i], reach);
        }
        return true;
    }
}