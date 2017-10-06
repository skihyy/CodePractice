package com.yuyang.he.lc.backwardtracking;

public class LC37_Sudoku_Solver
{

    public static void main(String[] args)
    {
        final String [] s = new String[] {"..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."};
        char [][] cc = new char[9][9];
        for(int i = 0; i < 9; i++)
            cc[i] = s[i].toCharArray();
        new LC37_Sudoku_Solver().solveSudoku(cc);
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++)
                System.out.print(cc[i][j] + " ");
            System.out.println();
        }
    }
    
    public final void solveSudoku(final char[][] board) {
        // row#, column#, 3X3 cell, which numbers are available
        boolean [][] row = new boolean[9][9], col = new boolean[9][9], cell = new boolean[9][9];
        // find available numbers
        for(int i = 0; i < 9; i++) // row
            for(int j = 0; j < 9; j++) // col
                if('.' != board[i][j]) {// it is a number
                    // minus '1' instead of 0 since '9' should be in cell 8, '1' in cell 0
                    final int num = board[i][j] - '1', cellNo = i / 3 * 3 + j / 3;
                    row[i][num] = true;
                    col[j][num] = true;
                    cell[cellNo][num] = true;
                }
        solveSudoku(board, row, col, cell);
    }
    
    private boolean solveSudoku(final char [][] board, final boolean [][] row, final boolean [][] col, final boolean [][] cell) {
        // backward tracking
        for(int i = 0; i < 9; i++)
            for(int j = 0; j < 9; j++)
                if('.' == board[i][j]) {
                    final int cellNo = i / 3 * 3 + j / 3;
                    for(int k = 0; k < 9; k++) // index is always 1 less than the real number it contains
                        if(!row[i][k] && !col[j][k] && !cell[cellNo][k])
                            if(isValid(board, i, j, (char)(k + '1'))) {
                                row[i][k] = col[j][k] = cell[cellNo][k] = true;
                                board[i][j] = (char)('1' + k);
                                if(solveSudoku(board, row, col, cell))
                                    return true;
                                row[i][k] = col[j][k] = cell[cellNo][k] = false;
                                board[i][j] = '.';
                            }
                    return false;
                }
        return true;
    }
    
    private boolean isValid(final char[][] board, final int row, final int col, final char num) {
        for(int i = 0; i < 9; i++)
            if(num == board[i][col])
                return false;
        for(int i = 0; i < 9; i++)
            if(num == board[row][i])
                return false;
        final int cellRow = row / 3 * 3, cellCol = col / 3 * 3;
        for(int i = cellRow + 2; i >= cellRow; i--)
            for(int j = cellCol + 2; j >= cellCol; j--)
                if(board[i][j] == num)
                    return false;
        return true;
    }

}
