package com.yuyang.he.lc.dp;

public class LC523_Continuous_Subarray_Sum
{

    public static void main(String[] args)
    {
        System.out.println(new LC523_Continuous_Subarray_Sum().checkSubarraySum(new int[] { 0, 1, 0 }, 0));
    }
    
    public final boolean checkSubarraySum(final int[] nums, final int k) {
        if(null == nums || 1 >= nums.length)
            return false;
        
        // dp[i] = sum of nums from 0 to i
        final int [] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1; i < dp.length; i++)
            dp[i] = dp[i - 1] + nums[i];
        
        for(int i = nums.length - 1; 0 < i; i--)
            if((0 != k && 0 == dp[i] % k) || (0 == k && k == dp[i])) // sum of nums from 0 to i
                return true;
            else
                for(int j = i - 2; 0 <= j; j--)
                    if((0 != k && 0 == (dp[i] - dp[j]) % k) || (0 == k && k == (dp[i] - dp[j]))) // sum of nums from 1, 2, ..., j to i
                        return true;
        
        return false;            
    }

}
