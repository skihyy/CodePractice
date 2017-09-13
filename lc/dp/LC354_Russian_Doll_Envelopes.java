package com.yuyang.he.lc.dp;

import java.util.Arrays;
import java.util.Comparator;

public class LC354_Russian_Doll_Envelopes
{
    public static void main(String[] args)
    {
        LC354_Russian_Doll_Envelopes lc354 = new LC354_Russian_Doll_Envelopes();
        System.out.println(lc354.maxEnvelopes(new int[][] { { 5, 4 }, { 6, 4 }, { 6, 7 }, { 2, 3 } }));
    }

    public int maxEnvelopes(int[][] envelopes)
    {
        if (null == envelopes || 0 == envelopes.length || 0 == envelopes[0].length)
            return 0;

        // sort envelopes
        // ascending order: width
        // descending order: height
        Arrays.sort(envelopes, new Comparator<int[]>()
        {
            public int compare(int[] a1, int[] a2)
            {
                if (a1[0] == a2[0])
                    return a2[1] - a1[1];
                else
                    return a1[0] - a2[0];
            }
        });

        // find the longest increasing subsequence based on height
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < envelopes.length; i++)
            for (int j = 0; j < i; j++)
                if (envelopes[i][1] > envelopes[j][1])
                    if (dp[j] + 1 > dp[i])
                        dp[i] = dp[j] + 1;

        int result = dp[0];
        for (int i = 1; i < dp.length; i++)
            if (dp[i] > result)
                result = dp[i];

        return result;
    }

}
