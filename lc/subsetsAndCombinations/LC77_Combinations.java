package com.yuyang.he.lc.subsetsAndCombinations;

import java.util.ArrayList;
import java.util.List;
/**
 * @author yuyanghe
 * @date 2017年1月11日
 * @version 1.0
 * @since 2017年1月11日
 */
public class LC77_Combinations
{
    public static void main(String[] args)
    {
        int size = -1;
        List<List<Integer>> res = new LC77_Combinations().combine(4, 2);

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

    public List<List<Integer>> combine(int maxNum, int len)
    {
        int[] nums = new int[maxNum];
        for (int i = 0; i < maxNum; ++i)
        {
            nums[i] = i + 1;
        }

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(res, new ArrayList<Integer>(), 0, nums, 0, len);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> curList, int curIndex, int[] nums, int start, int stop)
    {
        if (start == stop)
        {
            res.add(new ArrayList<Integer>(curList));
        }

        for (int i = curIndex; i < nums.length; i++)
        {
            curList.add(nums[i]);
            helper(res, curList, i + 1, nums, start + 1, stop);
            curList.remove(curList.size() - 1);
        }
    }

}
