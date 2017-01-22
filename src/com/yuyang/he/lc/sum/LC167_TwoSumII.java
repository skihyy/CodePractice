package com.yuyang.he.lc.sum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuyanghe
 * @date 2017年1月17日
 * @version 1.0
 * @since 2017年1月17日
 */
public class LC167_TwoSumII
{

    public static void main(String[] args)
    {
        int[] a = { 2, 3, 4 }, b = new LC167_TwoSumII().twoSum(a, 6);
        System.out.println(b[0] + " " + b[1]);
    }

    public int[] twoSum(int[] nums, int target)
    {
        int low = 0, high = nums.length - 1, mid = (high - low) / 2;

        while (low < high)
        {
            if (target >= nums[mid])
            {
                break;
            }
            else
            {
                high = mid;
                mid = (low + high) / 2;
            }
        }

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int res[] = new int[2];
        for (; low <= high; low++)
        {
            if (null != map.get(target - nums[low]))
            {
                res[1] = low;
                res[0] = map.get(target - nums[low]);
                break;
            }
            map.put(nums[low], low);
        }
        return res;
    }

}
