package com.yuyang.he.lc.subsetsAndCombinations;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuyanghe
 * @date 2017年1月11日
 * @version 1.0
 * @since 2017年1月11日
 */
public class LC78_Subsets
{
    public static void main(String[] args)
    {
        int[] a = { 1, 2, 3 };
        int size = -1;
        List<List<Integer>> res = new LC78_Subsets().subsets(a);

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

    public List<List<Integer>> subsets(int[] nums)
    {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(res, new ArrayList<Integer>(), 0, nums);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> curList, int start, int[] nums)
    {
        res.add(new ArrayList<Integer>(curList));
        for (int i = start; i < nums.length; i++)
        {
            curList.add(nums[i]);
            helper(res, curList, i + 1, nums);
            curList.remove(curList.size() - 1);
        }
    }
}
