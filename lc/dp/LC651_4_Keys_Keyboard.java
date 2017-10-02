package com.yuyang.he.lc.dp;

public class LC651_4_Keys_Keyboard
{

    // key 0 1 2 3 4 5 6 7 8  9
    // max 0 1 2 3 4 5 6 9 12 16
    // f(n) = max{f(n - 4) * 3, f(n - 5) * 4}
    // want to select-all, copy once, then paste paste paste ...
    // f(n - 3) * 2 is not the largest
    if(6 >= n)
        return n;
    final int [] dp = new int[n + 1];
    for(int i = 0; i <= n; i++)
        if(7 > i)
            dp[i] = i;
        else
            dp[i] = Math.max(dp[i - 4] * 3, dp[i - 5] * 4);
    return dp[n];

}
