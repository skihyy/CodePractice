package com.yuyang.he.lc.dp;

public class LC308_Range_Sum_Query_2D_Mutable
{

    public static void main(String[] args)
    {
        LC308_Range_Sum_Query_2D_Mutable lc308 = new LC308_Range_Sum_Query_2D_Mutable(new int[][] { { 3, 0, 1, 4, 2 }, { 5, 6, 3, 2, 1 },
            { 1, 2, 0, 1, 5 }, { 4, 1, 0, 1, 7 }, { 1, 0, 3, 0, 5 } });
        lc308.update(3, 2, 2);
        System.out.println();
    }

    // dp[i][j] = in i-th row of m, the sum from 0 to j (inclusive)
    private int[][] m, dp = new int[][] { {} };

    public LC308_Range_Sum_Query_2D_Mutable(final int[][] matrix)
    {
        m = matrix;
        if(null != m && 0 != m.length && 0 != m[0].length) {
            dp = new int [m.length][m[0].length];
            for(int i = 0; i < m.length; i++) {
                dp[i][0] = m[i][0];
                for(int j = 1; j < m[0].length; j++)
                    dp[i][j] = m[i][j] + dp[i][j - 1];
            }
        }
    }

    public void update(final int row, final int col, final int val)
    {
        final int diff = m[row][col] - val;
        m[row][col] = val;
        for (int i = col; i < m[0].length; i++)
            dp[row][i] -= diff;
    }

    public int sumRegion(int row1, int col1, int row2, int col2)
    {
        int sum = 0;
        for (int i = row1; i <= row2; i++)
            sum += 0 == col1 ? dp[i][col2] : dp[i][col2] - dp[i][col1 - 1];
        return sum;
    }
}
