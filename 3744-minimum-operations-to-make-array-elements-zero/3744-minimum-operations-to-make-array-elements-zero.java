class Solution {
    private static final byte[] SMALL_OPS = new byte[1024];
    
    static {
        for (int i = 1; i < 1024; i++) {
            SMALL_OPS[i] = (byte)computeOpsForNumber(i);
        }
    }
    
    private static int computeOpsForNumber(int x) {
        if (x <= 3) return 1;
        if (x <= 15) return 2;
        if (x <= 63) return 3;
        if (x <= 255) return 4;
        return 5; // For numbers >= 256 in our small table
    }
    
    public long minOperations(int[][] queries) {
        long result = 0;
        
        for (int[] q : queries) {
            result += fastCompute(q[0], q[1]);
        }
        
        return result;
    }
    
    private long fastCompute(int l, int r) {
        long totalOps = 0;
        int current = l;
        
        while (current <= r) {
            int ops = getOpsNeeded(current);
            long rangeEnd = Math.min(r, getBoundary(ops));
            long count = rangeEnd - current + 1;
            totalOps += count * ops;
            current = (int)(rangeEnd + 1);
        }
        
        return (totalOps + 1) >> 1;
    }
    
    private int getOpsNeeded(int x) {
        if (x < 1024) return SMALL_OPS[x];
        
        // For larger numbers, use direct computation
        if (x <= 4095) return 6;
        if (x <= 16383) return 7;
        if (x <= 65535) return 8;
        if (x <= 262143) return 9;
        if (x <= 1048575) return 10;
        if (x <= 4194303) return 11;
        if (x <= 16777215) return 12;
        if (x <= 67108863) return 13;
        if (x <= 268435455) return 14;
        if (x <= 1073741823) return 15;
        return 16;
    }
    
    private long getBoundary(int ops) {
        switch (ops) {
            case 1: return 3;
            case 2: return 15;
            case 3: return 63;
            case 4: return 255;
            case 5: return 1023;
            case 6: return 4095;
            case 7: return 16383;
            case 8: return 65535;
            case 9: return 262143;
            case 10: return 1048575;
            case 11: return 4194303;
            case 12: return 16777215;
            case 13: return 67108863;
            case 14: return 268435455;
            case 15: return 1073741823;
            default: return 4294967295L;
        }
    }
}