class Solution {
    public void wiggleSort(int[] nums) {
        int[] res = Arrays.copyOf(nums, nums.length);
        Arrays.sort(res);

        int n = nums.length - 1;

        for(int i = 1; i < nums.length; i+=2) nums[i] = res[n--];

        for(int i = 0; i < nums.length; i+=2) nums[i] = res[n--];
    }
}