class Solution {
    public boolean isValidSudoku(char[][] board) {

        for(int i = 0; i < 9; i++) {
            boolean[] check = new boolean[9];
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    int v = board[i][j] - '1';
                    if(check[v]) return false;
                    else check[v] = true;
                }
            }
        }

        for(int i = 0; i < 9; i++) {
            boolean[] check = new boolean[9];
            for(int j = 0; j < 9; j++) {
                if(board[j][i] != '.') {
                    int v = board[j][i] - '1';
                    if(check[v]) return false;
                    else check[v] = true;
                }
            }
        }
        
        for(int b = 0; b < 9; b++) {
            boolean[] check = new boolean[9];
            int row = (b / 3) * 3;
            int col = (b % 3) * 3;
            for(int i = row; i < row + 3; i++) {
                for(int j = col; j < col + 3; j++) {
                    if(board[i][j] != '.') {
                        int v = board[i][j] - '1';
                        if(check[v]) return false;
                        else check[v] = true;
                    }
                }
            }
        }
        return true;
    }
}