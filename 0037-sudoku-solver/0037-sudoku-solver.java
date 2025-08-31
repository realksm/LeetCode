class Solution {
    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }

    public boolean solve(char[][] board, int row, int col) {
        if (col == board[0].length) {
            col = 0;
            row += 1;
        }
        if (row == board.length)
            return true;

        if (board[row][col] != '.')
            return solve(board, row, col + 1);

        for (char temp = '1'; temp <= '9'; temp++) {
            if (isSafe(board, row, col, temp)) {
                board[row][col] = temp;
                boolean solved = solve(board, row, col + 1);
                if (solved)
                    return true;
                else
                    board[row][col] = '.';
            }
        }
        return false;
    }

    public boolean isSafe(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c || board[row][i] == c || board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
                return false;
        }
        return true;
    }
}