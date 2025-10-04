class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxVolume = Integer.MIN_VALUE;

        while(left < right) {
            int h = Math.min(height[left],height[right]);
            int l = right - left;
            maxVolume = Math.max(maxVolume,h*l);
            if(height[left] < height[right]) left++;
            else right--;
        }

        return maxVolume;
    }
}