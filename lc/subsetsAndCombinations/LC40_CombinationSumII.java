package com.yuyang.he.lc.subsetsAndCombinations;

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
public class LC40_CombinationSumII
{
    public static void main(String[] args)
    {
        int[] a = { 10, 1, 2, 7, 6, 1, 5 };
        int size = -1;
        List<List<Integer>> res = new LC40_CombinationSumII().combinationSum(a, 8);

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

    public List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(res, new ArrayList<Integer>(), target, candidates, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> curList, int target, int[] nums, int start)
    {
        int sum = sum(curList);
        List<Integer> tmp = new ArrayList<Integer>(curList);
        if (target == sum)
        {
            Collections.sort(tmp);
            if (!res.contains(tmp))
            {
                res.add(tmp);
            }
        }
        else if (target > sum)
        {
            for (int i = start; i < nums.length; i++)
            {
                curList.add(nums[i]);
                helper(res, curList, target, nums, i + 1);
                curList.remove(curList.size() - 1);
            }
        }
    }

    private int sum(List<Integer> list)
    {
        int sum = 0;
        for (int i : list)
        {
            sum += i;
        }
        return sum;
    }
}
