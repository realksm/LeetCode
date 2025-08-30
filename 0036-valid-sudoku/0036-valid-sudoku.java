class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] mask = new int[3][9]; // 0=row, 1=col, 2=box

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.')
                    continue;

                int bit = 1 << (c - '0');
                int box = (i / 3) * 3 + (j / 3);

                if ((mask[0][i] & bit) != 0 ||
                        (mask[1][j] & bit) != 0 ||
                        (mask[2][box] & bit) != 0)
                    return false;

                mask[0][i] |= bit;
                mask[1][j] |= bit;
                mask[2][box] |= bit;
            }
        }
        return true;
    }
}