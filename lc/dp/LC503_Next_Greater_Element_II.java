package com.yuyang.he.lc.dp;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LC503_Next_Greater_Element_II
{

    public static void main(String[] args)
    {
        final int [] r = new LC503_Next_Greater_Element_II().nextGreaterElements(new int[] {1,2,1});
        for(final int i : r)
            System.out.println(i);
    }

    public final int[] nextGreaterElements(final int[] nums)
    {
        // position of x -> position of the larger number of x
        final Map<Integer, Integer> map = new HashMap<>();
        final Stack<Integer> stack = new Stack<>();
        helper(nums, stack, map);
        helper(nums, stack, map);
        final int[] result = new int[nums.length];
        for (int i = 0; i < result.length; i++)
            result[i] = map.containsKey(i) ? nums[map.get(i)] : -1;
        return result;
    }

    private void helper(final int[] nums, final Stack<Integer> stack, final Map<Integer, Integer> map)
    {
        for (int i = 0; i < nums.length; i++)
        {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i])
                map.putIfAbsent(stack.pop(), i);
            stack.push(i);
        }
    }

}
