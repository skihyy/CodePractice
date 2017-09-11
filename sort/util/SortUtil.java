package com.yuyang.he.sort.util;

/**
 * @author yuyanghe
 * @date 2016年12月23日
 * @version 1.0
 * @since 2016年12月23日
 */
public class SortUtil
{
    public static void printNum(int[] a)
    {
        System.out.print("[");
        for (int i = 0; i < a.length - 1; ++i)
        {
            System.out.print(a[i] + ", ");
        }
        System.out.println(a[a.length - 1] + "]");
    }
    
    public static void swap(int[] nums, int pos1, int pos2)
    {
        int tmp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = tmp;
    }
}
