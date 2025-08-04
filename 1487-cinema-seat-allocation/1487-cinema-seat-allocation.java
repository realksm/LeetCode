class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int[] rows : reservedSeats) {
            map.put(rows[0], map.getOrDefault(rows[0], 0) | 1 << rows[1] - 1);
        }
        int count = 0;
        for(int seats : map.values()) {
            if((seats & 0b0111111110) == 0) count += 2;
            else if((seats & 0b0111100000) == 0 ||
                    (seats & 0b0001111000) == 0 ||
                    (seats & 0b0000011110) == 0) {
                        count++;
                    }
        }
        return count + (n - map.size()) * 2;
    }
}