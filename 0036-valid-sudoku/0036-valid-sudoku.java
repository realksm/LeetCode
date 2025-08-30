class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] mask = new int[27];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.')
                    continue;

                int bit = 1 << (c - '0');
                int box = (i / 3) * 3 + (j / 3);

                int rowIndex = i;
                int colIndex = 9 + j;
                int boxIndex = 18 + box;

                if ((mask[rowIndex] & bit) != 0 ||
                        (mask[colIndex] & bit) != 0 ||
                        (mask[boxIndex] & bit) != 0)
                    return false;

                mask[rowIndex] |= bit;
                mask[colIndex] |= bit;
                mask[boxIndex] |= bit;
            }
        }
        return true;
    }
}