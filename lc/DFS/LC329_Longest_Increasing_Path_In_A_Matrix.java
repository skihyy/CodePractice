package com.yuyang.he.lc.dfs;

public class LC329_Longest_Increasing_Path_In_A_Matrix
{

    public static void main(String[] args)
    {
        System.out.println(new LC329_Longest_Increasing_Path_In_A_Matrix()
                .longestIncreasingPath(new int[][] { { 3, 4, 5 }, { 3, 2, 6 }, { 2, 2, 1 } }));
    }

    private int[][] matrix, dp;

    public int longestIncreasingPath(final int[][] matrix)
    {
        if (null == matrix || 0 == matrix.length || 0 == matrix[0].length)
            return 0;

        this.matrix = matrix;

        // use dp to store the longest length for the current point
        dp = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                helper(i, j, 0);

        int max = dp[0][0];
        for (int i = 0; i < dp.length; i++)
            for (int j = 0; j < dp[0].length; j++)
                max = Math.max(max, dp[i][j]);

        return max;
    }

    private void helper(final int y, final int x, int length)
    {
        length++;
        // left
        if (0 <= x - 1)
        {
            // must larger than itself
            if (matrix[y][x - 1] > matrix[y][x])
            {
                // if length has been calculated
                if (0 == dp[y][x - 1])
                    helper(y, x - 1, 0);
                dp[y][x] = Math.max(dp[y][x - 1] + length, dp[y][x]);

            }
        }
        // right
        if (matrix[0].length > x + 1)
        {
            // must larger than itself
            if (matrix[y][x + 1] > matrix[y][x])
            {
                if (0 == dp[y][x + 1])
                    helper(y, x + 1, 0);
                dp[y][x] = Math.max(dp[y][x + 1] + length, dp[y][x]);
            }
        }
        // up
        if (0 <= y - 1)
        {
            // must larger than itself
            if (matrix[y - 1][x] > matrix[y][x])
            {
                if (0 == dp[y - 1][x])
                    helper(y - 1, x, 0);
                dp[y][x] = Math.max(dp[y - 1][x] + length, dp[y][x]);
            }
        }
        // down
        if (matrix.length > y + 1)
        {
            // must larger than itself
            if (matrix[y + 1][x] > matrix[y][x])
            {
                if (0 == dp[y + 1][x])
                    helper(y + 1, x, 0);
                dp[y][x] = Math.max(dp[y + 1][x] + length, dp[y][x]);
            }
        }

        dp[y][x] = Math.max(length, dp[y][x]);
    }

}
