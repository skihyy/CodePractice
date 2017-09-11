package com.yuyang.he.lc.dp;

import java.util.Arrays;

public class LC300_Longest_Increasing_Subsequence
{

    public int lengthOfLIS(int[] nums)
    {
        if (1 >= nums.length)
            return nums.length;

        // at position j, dp[j] represents the length of the longest increasing
        // subsequence ends at j
        int[] dp = new int[nums.length];

        // at least, the longest increasing subsequence is itself, which is 1
        Arrays.fill(dp, 1);

        // check starts from 2nd element
        // if the element previous to i-th element, which is j-th element, is
        // less than it, then the length should be increased by 1
        for (int i = 1; i < nums.length; i++)
            for (int j = 0; j < i; j++)
                if (nums[j] < nums[i])
                    if (dp[j] + 1 > dp[i])
                        dp[i] = dp[j] + 1;

        int max = dp[0];
        for (int i = 1; i < dp.length; i++)
            if (max < dp[i])
                max = dp[i];

        return max;
    }

    public static void main(String[] args)
    {
        LC300_Longest_Increasing_Subsequence l = new LC300_Longest_Increasing_Subsequence();
        System.out.println(l.lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 4 }));
    }
}
