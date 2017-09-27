package com.yuyang.he.lc.dp;

public class LC560_Subarray_Sum_Equals_K
{

    public static void main(String[] args)
    {
        System.out.println(new LC560_Subarray_Sum_Equals_K().subarraySum(new int[] { 1, 1, 1 }, 2));
    }
    
    public final int subarraySum(final int[] nums, final int k) {
        if(null == nums || 0 == nums.length)
            return 0;
        
        final int [] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1; i < nums.length; i++)
            dp[i] = dp[i - 1] + nums[i];
        
        int count = 0;
        for(int i = nums.length - 1; 0 <= i; i--) {
            if(k == dp[i]) // sum of nums from 0, 1, ..., i
                count++;
            for(int j = i - 1; 0 <= j; j--)
                if(k == dp[i] - dp[j]) // sum of nums from 1, 2, ..., i
                    count++;
        }
        
        return count;
    }

}
