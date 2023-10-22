class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int c1 = 0, c2 = 0, e1 = 0, e2 = 0;

        for(int num : nums) {
            if(e1 == num) {
                c1++;
            } else if(e2 == num) {
                c2++;
            } else if(c1 == 0) {
                c1 = 1;
                e1 = num;
            } else if(c2 == 0) {
                c2 = 1;
                e2 = num;
            } else {
                c1--;
                c2--;
            }
        }

        List<Integer> res = new ArrayList<>();
        int th = nums.length/3;

        c1 = 0; 
        c2 = 0;

        for(int num : nums) {
            if(e1 == num) c1++;
            else if(e2 == num) c2++;
        }

        if(c1 > th) res.add(e1);
        if(c2 > th) res.add(e2);
        return res;
    }
}