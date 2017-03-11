package com.yuyang.he.lc.numbers;

/**
 * @author yuyanghe
 * @date 2017年3月7日
 * @version 1.0
 * @since 2017年3月7日
 */
public class LC463_Island_Perimeter
{

    public static void main(String[] args)
    {
        int[][] a = { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };
        System.out.println(new LC463_Island_Perimeter().islandPerimeter(a));
    }

    public int islandPerimeter(int[][] grid)
    {
        if (null == grid || 0 == grid.length || 0 == grid[0].length)
            return 0;
        int res = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
            {
                if (1 == grid[i][j])
                    res++;
                // up
                if (0 < i && 1 == grid[i - 1][j])
                    res -= 2;
                if (0 < j && 1 == grid[i][j - 1])
                    res -= 2;
            }
        return res;
    }
}
