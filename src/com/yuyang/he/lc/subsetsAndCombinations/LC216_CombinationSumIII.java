package com.yuyang.he.lc.subsetsAndCombinations;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuyanghe
 * @date 2017年1月11日
 * @version 1.0
 * @since 2017年1月11日
 */
public class LC216_CombinationSumIII
{
    public static void main(String[] args)
    {
        int size = -1;
        List<List<Integer>> res = new LC216_CombinationSumIII().combinationSum3(3, 9);

        for (List<Integer> list : res)
        {
            size = list.size();
            System.out.print("[");
            for (int i = 0; i < size; i++)
            {
                System.out.print(list.get(i));
                if (i + 1 < size)
                {
                    System.out.print(",");
                }
            }
            System.out.println("]");
        }
    }

    public List<List<Integer>> combinationSum3(int len, int target)
    {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(res, new ArrayList<Integer>(), target, nums, 0, len);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> curList, int target, int[] nums, int start, int len)
    {
        int size = curList.size();
        if (len == size)
        {
            if (0 == target)
            {
                res.add(new ArrayList<Integer>(curList));
            }
        }
        else if (size < len)
        {
            if (0 < target)
            {
                for (int i = start; i < nums.length; i++)
                {
                    curList.add(nums[i]);
                    helper(res, curList, target - nums[i], nums, i + 1, len);
                    curList.remove(curList.size() - 1);
                }
            }
        }
    }
}
