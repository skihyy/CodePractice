package com.yuyang.he.lc.numbers;

public class LC200_NumberOfIslands
{

    public static void main(String[] args)
    {
        char[][] a = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' } };
        System.out.println(new LC200_NumberOfIslands().numIslands(a));
    }

    public int numIslands(char[][] grid)
    {
        int row = grid.length, col = 0 == row ? 0 : grid[0].length, res = 0;
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                if ('1' == grid[i][j])
                {
                    res++;
                    helper(grid, row, col, i, j);
                }
        return res;
    }

    private void helper(char[][] grid, final int row, final int col, final int i, final int j)
    {
        if ('1' == grid[i][j])
            grid[i][j] = '0';
        else
            return;
        if (0 <= i - 1)
            helper(grid, row, col, i - 1, j);
        if (0 <= j - 1)
            helper(grid, row, col, i, j - 1);
        if (row > i + 1)
            helper(grid, row, col, i + 1, j);
        if (col > j + 1)
            helper(grid, row, col, i, j + 1);
    }
}
