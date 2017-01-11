package com.yuyang.he.lc.subsetsAndCombinations;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuyanghe
 * @date 2017年1月11日
 * @version 1.0
 * @since 2017年1月11日
 */
public class AllCombinations
{

    public static void main(String[] args)
    {
        int[] a = { 1, 2, 3 };
        int size = -1;
        List<List<Integer>> res = new AllCombinations().allCombinations(a);

        for (List<Integer> list : res)
        {
            size = list.size();
            System.out.print("[");
            for (int i = 0; i < size; i++)
            {
                System.out.print(list.get(i));
                if(i + 1 < size)
                {
                    System.out.print(",");
                }
            }
            System.out.println("]");
        }
    }

    public List<List<Integer>> allCombinations(int[] nums)
    {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>()); // limit = 0

        for (int i = 1; i <= nums.length; i++)
        {
            helper(nums, i, new ArrayList<Integer>(), new ArrayList<Integer>(), res);
        }

        return res;
    }

    private void helper(int[] nums, int limit, List<Integer> excluded, List<Integer> curList, List<List<Integer>> res)
    {
        if (0 == limit)
        {
            res.add(curList);
            return;
        }

        for (int i = 0; i < nums.length; i++)
        {
            List<Integer> newExcList = new ArrayList<Integer>(excluded), newCurList = new ArrayList<Integer>(curList);
            if (!excluded.contains(nums[i]))
            {
                newExcList.add(nums[i]);
                newCurList.add(nums[i]);
                helper(nums, limit - 1, newExcList, newCurList, res);
            }
        }
    }

}
