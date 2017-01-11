package com.yuyang.he.lc.sum;

import java.util.Arrays;
/**
 * @author yuyanghe
 * @date 2017年1月11日
 * @version 1.0
 * @since 2017年1月11日
 */
public class LC16_ThreeSumClose
{
    public static void main(String[] args)
    {
        int[] a = { 1, 1, 1, 0 };
        new LC16_ThreeSumClose().threeSumClose(a, 100);
    }

    public int threeSumClose(int[] nums, int target)
    {
        Arrays.sort(nums);
        int curSum = -1, low = -1, high = -1, diff = Integer.MAX_VALUE, tmpDiff = -1;
        for (int i = 0; i < nums.length - 2; i++)
        {
            curSum = target - nums[i];
            low = i + 1;
            high = nums.length - 1;

            while (low < high)
            {
                tmpDiff = curSum - nums[low] - nums[high];

                if (Math.abs(tmpDiff) < Math.abs(diff))
                {
                    diff = tmpDiff;

                    while (low < high && nums[low] == nums[low + 1])
                    {
                        low++;
                    }

                    while (low < high && nums[high] == nums[high - 1])
                    {
                        high--;
                    }
                }
                else if (0 > tmpDiff)
                {
                    high--;
                }
                else
                {
                    low++;
                }
            }
        }

        return target - diff;
    }
}
