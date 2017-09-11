package com.yuyang.he.lc.amazon;

/**
 * Given a list of integers, and a window size k, return a list of window sum,
 * sliding from left to right.
 * 
 * @author yuyanghe
 * @date 2017年1月16日
 * @version 1.0
 * @since 2017年1月16日
 */
public class WindowsSum
{
    public static void main(String[] args)
    {
        int [] a = {1,2,3,4,5,6,7,8}, b = new WindowsSum().windowSum(a, 4);
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for(int i = 0 ; i < b.length - 1; i++)
        {
            sb.append(b[i]);
            sb.append(',');
        }
        sb.append(b[b.length - 1]);
        sb.append(']');
        System.out.println(sb.toString());
    }

    public int[] windowSum(int[] list, int k)
    {
        int start = 0, curSum = 0, ptr = 0;
        int[] res = new int[list.length + 1 - k];
        
        for(int i = 0; i < list.length; i++)
        {
            curSum += list[i];
            if(k - 1 == i - start)
            {
                res[ptr++] = curSum;
                curSum -= list[start++];
            }
        }

        return res;
    }
}
