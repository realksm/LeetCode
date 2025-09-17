class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        int[] Aneg = getNegatives(nums1);
        int[] Apos = getPositives(nums1);

        int[] Bneg = getNegatives(nums2);
        int[] Bpos = getPositives(nums2);

        long count = (long) Aneg.length * Bpos.length + (long) Bneg.length * Apos.length;
        int sign = 1;
        if(k <= count) {
            k = count - k + 1;
            sign = -1;

            int[] temp = Bneg;
            Bneg = Bpos;
            Bpos = temp;
        } else {
            k -= count;
        } 

        long left = 0, right = (long) 1e10;
        while(left < right) {
            long mid = (left + right) >>> 1;
            if(countPairs(Aneg, Bneg, mid) + countPairs(Apos, Bpos, mid) >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return sign * left;
    }

    private int[] getNegatives(int[] arr) {
        int count = 0;
        for(int x : arr) count += (x >> 31) != 0 ? 1 : 0;
        int[] res = new int[count];
        for(int x : arr) if(x < 0) res[--count] = -x;
        return res;
    }

    private int[] getPositives(int[] arr) {
        int count = 0;
        for(int x : arr) count += (x >> 31) == 0 ? 1 : 0;
        int[] res = new int[count];
        int idx = 0;
        for(int x : arr) if(x >= 0) res[idx++] = x;
        return res;
    }

    private long countPairs(int[] A, int[] B, long M) {
        long count = 0;
        int j = B.length - 1;
        for(int a : A) {
            while(j >= 0 && (long) a * B[j] > M) j--;
            count += j + 1;
        }
        return count;
    }
}