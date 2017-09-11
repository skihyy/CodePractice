package com.yuyang.he.lc.sum;

public class LC493_ReversePairs
{

    public static void main(String[] args)
    {
        int[] a = { 1, 3, 2, 5, 6, 8 };
        System.out.println(new LC493_ReversePairs().reversePairs(a));
    }

    public int reversePairs(int[] nums)
    {
        double[] dnums = new double[nums.length], halfNums = new double[nums.length];
        for (int i = 0; i < nums.length; i++)
        {
            dnums[i] = nums[i];
            halfNums[i] = dnums[i] / 2;
        }

        int res = 0;
        for (int i = 0; i < dnums.length - 1; i++)
            for (int j = i + 1; j < dnums.length; j++)
                if (halfNums[i] > dnums[j])
                    res++;

        return res;
    }

}
