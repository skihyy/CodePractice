package com.yuyang.he.lc.subsetsAndCombinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yuyanghe
 * @date 2017年1月11日
 * @version 1.0
 * @since 2017年1月11日
 */
public class LC39_CombinationSum
{
    public static void main(String[] args)
    {
        int[] b = { 1, 2 };
        int size = -1;
        List<List<Integer>> res = new LC39_CombinationSum().combinationSum(b, 4);

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

    private void helper(List<List<Integer>> res, ArrayList<Integer> curList, int target, int[] nums, int start)
    {
        if (0 == target)
        {
            res.add(new ArrayList<Integer>(curList));
        }
        else if (0 < target)
        {
            for (int i = start; i < nums.length; i++)
            {
                curList.add(nums[i]);
                helper(res, curList, target - nums[i], nums, i);
                curList.remove(curList.size() - 1);
            }
        }
    }
}
