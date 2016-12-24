package com.yuyang.he.sort;

import com.yuyang.he.sort.util.SortUtil;

public class QuickSort
{
    public static void main(String[] args)
    {
        int[] a = { 9, 1, 5, 3, 4, 2, 6, 8, 7, 3 };
        SortUtil.printNum(a);
        sort(a);
        SortUtil.printNum(a);
    }

    public static void sort(int[] nums)
    {
        quickSortHelper(nums, 0, nums.length - 1);
    }

    private static void quickSortHelper(int[] nums, int left, int right)
    {
        if(0 > left || 0 > right || left >= right)
        {
            return;
        }
        
        int pivotPos = left, inileft = left, iniRight = right;

        while (left < right)
        {
            while (nums[pivotPos] < nums[right] && left < right)
            {
                right--;
            }
            if(nums[pivotPos] > nums[right] && left < right)
            {
                SortUtil.swap(nums, pivotPos, right);
                pivotPos = right;
                right--;
            }

            while (nums[pivotPos] > nums[left] && left < right)
            {
                left++;
            }
            if(nums[pivotPos] < nums[left] && left < right)
            {
                SortUtil.swap(nums, pivotPos, left);
                pivotPos = left;
                left++;
            }
        }

        System.out.print("Pivot: " + nums[pivotPos] + ", ");
        SortUtil.printNum(nums);

        quickSortHelper(nums, inileft, pivotPos - 1);
        quickSortHelper(nums, pivotPos + 1, iniRight);
    }
}
