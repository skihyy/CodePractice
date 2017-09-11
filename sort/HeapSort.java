package com.yuyang.he.sort;

import com.yuyang.he.sort.util.SortUtil;

/**
 * @author yuyanghe
 * @date 2016年12月23日
 * @version 1.0
 * @since 2016年12月23日
 */
public class HeapSort
{
    public static void main(String[] args)
    {
        int[] a = { 9, 1, 5, 3, 4, 2, 6, 8, 7, 3 };
        sort(a);
        SortUtil.printNum(a);
    }

    public static void sort(int[] nums)
    {
        adjustHeap(nums, 0);
    }

    private static void adjustHeap(int[] nums, int curPtr)
    {
        int lChild = 1 + 2 * curPtr, rChild = 2 + 2 * curPtr, curMaxPtr = curPtr;
        
        if(curPtr < nums.length / 2)
        {
            if(nums[lChild] > nums[curMaxPtr] && lChild < nums.length)
            {
                curMaxPtr = curPtr;
            }
            
            if(nums[rChild] > nums[curMaxPtr] && rChild < nums.length)
            {
                curMaxPtr = curPtr;
            }
            
            
        }
    }
}
