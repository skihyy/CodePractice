package com.yuyang.he.lc.subsetsAndCombinations;

import java.util.Arrays;

/**
 * @author yuyanghe
 * @date 2017年1月11日
 * @version 1.0
 * @since 2017年1月11日
 */
public class LC377_CombinationSumIV
{
    private int[] res = null;

    public static void main(String[] args)
    {
        int[] b = { 1, 2, 3 };
        System.out.println(new LC377_CombinationSumIV().combinationSum(b, 4));
    }

    public int combinationSum(int[] nums, int target)
    {
        Arrays.sort(nums);
        res = new int[1 + target];
        Arrays.fill(res, -1);
        res[0] = 1;
        return helper(nums, target);
    }

    private int helper(int[] nums, int target)
    {
        if (-1 != res[target])
        {
            return res[target];
        }

        int result = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (target >= nums[i])
            {
                result += helper(nums, target - nums[i]);
            }
        }
        res[target] = result;
        return result;
    }

}
