package com.yuyang.he.lc.numbers;

public class LC130_SurroundedRegions
{

    public static void main(String[] args)
    {
        String[] s = { "OOOOOO", "OXXXXO", "OXOOXO", "OXOOXO", "OXXXXO", "OOOOOO" };
        char[][] a = new char[s.length][];
        for (int i = 0; i < s.length; i++)
            a[i] = s[i].toCharArray();
        new LC130_SurroundedRegions().solve(a);
        for (char[] b : a)
        {
            for (char c : b)
                System.out.print(c);
            System.out.println();
        }
    }

    public void solve(char[][] board)
    {
        int row = board.length, col = 0 == row ? 0 : board[0].length;
        for (int i = 1; i < row - 1; i++)
            for (int j = 1; j < col - 1; j++)
                if ('O' == board[i][j])
                    if (check(board, row, col, i, j))
                        paint(board, row, col, i, j, true);
                    else
                        paint(board, row, col, i, j, false);
    }

    private boolean check(char[][] board, final int row, final int col, final int i, final int j)
    {
        board[i][j] = '1'; // checked
        boolean u = up(board, row, col, i, j), d = down(board, row, col, i, j), l = left(board, row, col, i, j),
                r = right(board, row, col, i, j);

        if (!u && 0 < i - 1)
            u = check(board, row, col, i - 1, j);
        // no need to check edge
        if (!d && row > i + 2)
            d = check(board, row, col, i + 1, j);
        if (!l && 0 < j - 1)
            l = check(board, row, col, i, j - 1);
        if (!r && col > j + 2)
            r = check(board, row, col, i, j + 1);
        return u && d && l && r;
    }

    private boolean up(char[][] board, final int row, final int col, final int i, final int j)
    {
        return 0 <= i - 1 ? 'O' != board[i - 1][j] : false;
    }

    private boolean down(char[][] board, final int row, final int col, final int i, final int j)
    {
        return row > i + 1 ? 'O' != board[i + 1][j] : false;
    }

    private boolean left(char[][] board, final int row, final int col, final int i, final int j)
    {
        return 0 <= j - 1 ? 'O' != board[i][j - 1] : false;
    }

    private boolean right(char[][] board, final int row, final int col, final int i, final int j)
    {
        return col > j + 1 ? 'O' != board[i][j + 1] : false;
    }

    private void paint(char[][] board, final int row, final int col, final int i, final int j, final boolean printToX)
    {
        if ('1' == board[i][j])
        {
            if (printToX)
                board[i][j] = 'X';
            else
                board[i][j] = 'O';
            if (0 <= i - 1)
                paint(board, row, col, i - 1, j, printToX);
            if (0 <= j - 1)
                paint(board, row, col, i, j - 1, printToX);
            if (row > i + 1)
                paint(board, row, col, i + 1, j, printToX);
            if (col > j + 1)
                paint(board, row, col, i, j + 1, printToX);
        }
    }

}
