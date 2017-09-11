package com.yuyang.he.lc.numbers;

import java.util.Arrays;

/**
 * @author yuyanghe
 * @date 2017年3月12日
 * @version 1.0
 * @since 2017年3月12日
 */
public class LC475_Heaters
{
    public static void main(String[] args)
    {
        int[] houses = { 1, 2, 3, 4 }, heaters = { 1, 4 };
        System.out.println(new LC475_Heaters().findRadius(houses, heaters));
    }

    public int findRadius(int[] houses, int[] heaters)
    {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int res = 0, heaterPos = 0;
        // for each house, find the small radius
        // but for radius, we need the maximum
        for (int house : houses)
        {
            while(heaters.length - 1 > heaterPos && 2 * house >= heaters[heaterPos] + heaters[heaterPos + 1])
                heaterPos++;
            res = Math.max(res, Math.abs(house - heaters[heaterPos]));
        }
        return res;
    }
}
