package com.yuyang.he.lc.sum;

public class LC494_Target_Sum
{

    public static void main(String[] args)
    {
        System.out.println(new LC494_Target_Sum().findTargetSumWays(new int[] { 1, 1, 1, 1, 1 }, 3));
    }

    private int count = 0;

    public int findTargetSumWays(final int[] nums, final int S) {
        helper(nums, S, 0, 0);
        return count;
    }
    
    private void helper(final int[] nums, final int target, final int pos, final int sum){
        if (pos == nums.length) {
            if (target == sum) count++;
            return;
        }
        helper(nums, target, pos + 1, sum + nums[pos]);
        helper(nums, target, pos + 1, sum - nums[pos]);
    }

}
