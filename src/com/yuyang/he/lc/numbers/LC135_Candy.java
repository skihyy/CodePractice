package com.yuyang.he.lc.numbers;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * @author yuyanghe
 * @date 2017年3月1日
 * @version 1.0
 * @since 2017年3月1日
 */
public class LC135_Candy
{

    public static void main(String[] args)
    {
        int[] a = { 1, 2, 4, 4, 3 };
        System.out.println(new LC135_Candy().candy(a));
    }

    public int candy(int[] ratings)
    {
        int[] candy = new int[ratings.length];
        // the 1st time, every one gets a candy
        for (int i = 0; i < candy.length; i++)
            candy[i] = 1;

        for (int i = 1; i < candy.length; i++)
            if (ratings[i] > ratings[i - 1])
                candy[i] = candy[i - 1] + 1;

        for (int i = candy.length - 1; i > 0; i--)
            if (ratings[i - 1] > ratings[i])
                candy[i - 1] = Math.max(candy[i] + 1, candy[i - 1]);

        return Arrays.stream(candy).reduce(0, Integer::sum);
    }

}
