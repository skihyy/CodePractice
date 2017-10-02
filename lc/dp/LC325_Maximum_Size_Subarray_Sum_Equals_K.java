package com.yuyang.he.lc.dp;

import java.util.HashMap;
import java.util.Map;

public class LC325_Maximum_Size_Subarray_Sum_Equals_K
{

    public static void main(String[] args)
    {
        System.out
                .println(new LC325_Maximum_Size_Subarray_Sum_Equals_K().maxSubArrayLen(new int[] { -2, -1, 2, 1 }, 1));
    }
    
    public final int maxSubArrayLen(final int[] nums, int k) {
        if(null == nums || 0 == nums.length)
            return 0;
        // pre-process data
        final int [] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1; i < dp.length; i++)
            dp[i] = dp[i - 1] + nums[i];
        
        // 2 sum
        // target -> end position in nums
        final Map<Integer, Integer> map = new HashMap<> ();
        map.put(0, -1); // make sum from 0 to j consistent
        int maxLength = 0;
        for(int i = 0; i < dp.length; i++) {
            maxLength = Math.max(maxLength, i - map.getOrDefault(dp[i] - k, i));
            map.putIfAbsent(dp[i], i); // make i as small as possible
        }
        return maxLength;                
    }

}
