package com.yuyang.he.lc.dfs;

public class LC351_Android_Unlock_Patterns
{

    public static void main(String[] args)
    {
        System.out.println(new LC351_Android_Unlock_Patterns().numberOfPatterns(2, 2));
    }
    
    private int curMove = 0;
    
    public final int numberOfPatterns(final int m, final int n) {
        int count = 0;
        final boolean [][] key = new boolean[3][3];
        for(int i = m; i <= n; i++) // the length of current pattern
            for(int j = 0; j < 2; j++) // 0, 1
                for(int k = 0; k < 2; k++) // 0, 1 (1, 3, 5, 7 or 2, 4, 6, 8 are the same)
                    if(!(1 == j && 0 == k)) {
                        dfs(key, i - 1, j, k);
                        count += 1 == i && 1 == j ? curMove : curMove * 4; // 1, 1 => start from 5, only one posibility
                        curMove = 0;
                    }
        return count;
    }
    
    private void dfs(final boolean[][] key, final int moveLeft, final int y, final int x) {
        if(0 == moveLeft) {
            curMove++;
            return;
        }
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                if(!(key[i][j] // the key cannot be pressed
                    || (i == y && Math.abs(j - x) > 1 && !key[y][1]) // the key cannot be cross over another unpressed key
                    || (j == x && Math.abs(i - y) > 1 && !key[1][x])
                    || ((y + x == i + j) && Math.abs(j - x) > 1 && !key[1][1]) // 1 cross 5 to 9 situation, 5 must be pressed
                    || ((y - x == i - j) && Math.abs(j - x) > 1 && !key[1][1])
                    || (y == i && x == j))) { // the key itself
                    key[i][j] = true;
                    dfs(key, moveLeft - 1, i, j);
                    key[i][j] = false;
                }
    }

}
