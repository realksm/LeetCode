class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
         Arrays.sort(reservedSeats, (a, b) -> a[0] - b[0]);

        int count = 0;
        int i = 0;
        int m = reservedSeats.length;

        while (i < m) {
            int row = reservedSeats[i][0];
            int mask = 0;

            // Gather all reserved seats for this row
            while (i < m && reservedSeats[i][0] == row) {
                int col = reservedSeats[i][1];
                mask |= 1 << (col - 1);
                i++;
            }

            boolean left = (mask & 0b0000011110) == 0;
            boolean middle = (mask & 0b0001111000) == 0;
            boolean right = (mask & 0b0111100000) == 0;

            if (left && right) count += 2;
            else if (left || middle || right) count += 1;
        }

        // Add 2 families per row not in reservedSeats
        int usedRows = 0;
        if (m > 0) {
            usedRows = (int) Arrays.stream(reservedSeats)
                                   .mapToInt(seat -> seat[0])
                                   .distinct()
                                   .count();
        }

        return count + (n - usedRows) * 2;
    }
}