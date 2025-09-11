class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        if(arr.length < 3) return false;

        int i = 2;
        for(;i < arr.length; i++) {
            if((arr[i - 2] & 1) + (arr[i - 1] & 1) + (arr[i] & 1) == 3) return true;
        }
        return false;
    }
}