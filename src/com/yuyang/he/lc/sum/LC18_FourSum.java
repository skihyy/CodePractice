package com.yuyang.he.lc.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/**
 * @author yuyanghe
 * @date 2017年1月11日
 * @version 1.0
 * @since 2017年1月11日
 */
public class LC18_FourSum
{
    public static void main(String[] args)
    {
        int[] a = { -1, 0, 1, 2, -1, -4 };
        new LC18_FourSum().fourSum(a, -1);
    }

    public List<List<Integer>> fourSum(int[] nums, int target)
    {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int curSum = -1, low = -1, high = -1;

        for (int i = 0; i < nums.length - 3; i++)
        {
            for (int j = i + 1; j < nums.length - 2; j++)
            {
                curSum = target - nums[i] - nums[j];
                low = j + 1;
                high = nums.length - 1;

                while (low < high)
                {
                    if (curSum == nums[low] + nums[high])
                    {
                        List<Integer> tmp = Arrays.asList(nums[i], nums[j], nums[low], nums[high]);
                        Collections.sort(tmp);

                        if (!res.contains(tmp))
                        {
                            res.add(tmp);
                        }

                        while (low < high && nums[low] == nums[low + 1])
                        {
                            low++;
                        }

                        while (low < high && nums[high] == nums[high - 1])
                        {
                            high--;
                        }

                        low++;
                        high--;
                    }
                    else if (curSum > nums[low] + nums[high])
                    {
                        low++;
                    }
                    else
                    {
                        high--;
                    }
                }
            }
        }

        return res;
    }
}
