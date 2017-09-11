package com.yuyang.he.sort;

import com.yuyang.he.sort.util.SortUtil;

/**
 * @author yuyanghe
 * @date 2016年12月23日
 * @version 1.0
 * @since 2016年12月23日
 */
public class MergeSort
{
    public static void main(String[] args)
    {
        int[] a = { 9, 1, 5, 3, 4, 2, 6, 8, 7, 3 };
        sort(a);
        SortUtil.printNum(a);
    }

    public static void sort(int[] nums)
    {
        mergeSortHelper(nums, new int[nums.length + 1], 0, nums.length - 1);
    }

    private static void mergeSortHelper(int[] nums, int[] helper, int startIndex, int endIndex)
    {
        if (startIndex < endIndex)
        {
            int splitPoint = (startIndex + endIndex) / 2;
            mergeSortHelper(nums, helper, startIndex, splitPoint);
            mergeSortHelper(nums, helper, splitPoint + 1, endIndex);
            merge(nums, helper, startIndex, splitPoint + 1, endIndex);
        }
    }

    private static void merge(int[] nums, int[] helper, int firstArrayIndex, int secondArrayIndex, int endIndex)
    {
        for (int i = firstArrayIndex; i <= endIndex; ++i)
        {
            helper[i] = nums[i];
        }

        int firstArrayPtr = firstArrayIndex, secondArrayPtr = secondArrayIndex, sortPtr = firstArrayIndex;

        while (firstArrayPtr < secondArrayIndex && secondArrayPtr <= endIndex)
        {
            if (helper[firstArrayPtr] < helper[secondArrayPtr])
            {
                nums[sortPtr] = helper[firstArrayPtr];
                firstArrayPtr++;
            }
            else
            {
                nums[sortPtr] = helper[secondArrayPtr];
                secondArrayPtr++;
            }
            sortPtr++;
        }

        while (true)
        {
            if (firstArrayPtr < secondArrayIndex)
            {
                nums[sortPtr] = helper[firstArrayPtr];
                firstArrayPtr++;
            }
            else if (secondArrayPtr <= endIndex)
            {
                nums[sortPtr] = helper[secondArrayPtr];
                secondArrayPtr++;
            }
            else
            {
                break;
            }
            sortPtr++;
        }
    }
}