package com.yuyang.he.lc.dp;

public class LC413_Arithmetic_Slices
{

    public static void main(String[] args)
    {
        System.out.println(new LC413_Arithmetic_Slices().numberOfArithmeticSlices(new int[] { 1, 2, 3, 4, 5, 6 }));
    }

    public final int numberOfArithmeticSlices(final int[] a)
    {
        if (2 >= a.length)
            return 0;
        final int[] diff = new int[a.length - 1];
        // compute the length of differences, thus the length of diff is less 1
        for (int i = 0; i < diff.length; i++)
            diff[i] = a[i + 1] - a[i];

        // dp[i] = the number of arithmetic slices so far at i
        final int[] dp = new int[diff.length];
        for (int i = 1; i < dp.length; i++)
            // since it is difference, as long as 2 differences are the same
            // it is a arithmetic slices
            if(diff[i - 1] == diff[i])
                // if the previous differences are also the same
                // it means the length of slices now has been larger than 3
                // give the following fact
                // array -> the number of arithmetic slices | differences between i and (i - 1)
                // {1}                -> 0  | nil
                // {1, 2}             -> 0  | 0
                // {1, 2, 3}          -> 1  | 1
                // {1, 2, 3, 4}       -> 3  | 2
                // {1, 2, 3, 4, 5}    -> 6  | 3
                // {1, 2, 3, 4, 5, 6} -> 10 | 4
                // every time, i-th element will increased by (dp[i - 1] - dp[i - 2] + 1)
                if(1 < i && diff[i - 2] == diff[i - 1]) 
                    // dp[i] = dp[i - 1] + (dp[i - 1] - dp[i - 2] + 1);
                    dp[i] = 2 * dp[i - 1] - dp[i - 2] + 1;
                else
                    dp[i] = dp[i - 1] + 1;
            else
                dp[i] = dp[i - 1];

        return dp[diff.length - 1];
    }
}
