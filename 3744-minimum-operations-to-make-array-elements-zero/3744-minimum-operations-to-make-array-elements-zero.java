class Solution {
    private static final int[] POWER_OF_4_MINUS_1 = {
        0, 3, 15, 63, 255, 1023, 4095, 16383, 65535, 262143, 
        1048575, 4194303, 16777215, 67108863, 268435455, 1073741823
    };
    
    public long minOperations(int[][] queries) {
        long totalResult = 0;
        
        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            totalResult += minOperationsForRange(l, r);
        }
        
        return totalResult;
    }
    
    private long minOperationsForRange(int l, int r) {
        long totalOperations = 0;
        
        int current = l;
        while (current <= r) {
            int opsNeeded = getOperationsNeeded(current);
            
            long rangeEnd = Math.min(r, (long)POWER_OF_4_MINUS_1[opsNeeded]);
            long count = rangeEnd - current + 1;
            
            totalOperations += count * opsNeeded;
            current = (int)(rangeEnd + 1);
        }
        
        return (totalOperations + 1) / 2;
    }
    
    private int getOperationsNeeded(int x) {
        for (int i = 1; i < POWER_OF_4_MINUS_1.length; i++) {
            if (x <= POWER_OF_4_MINUS_1[i]) {
                return i;
            }
        }
        return POWER_OF_4_MINUS_1.length - 1;
    }
}