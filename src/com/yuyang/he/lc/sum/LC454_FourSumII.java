package com.yuyang.he.lc.sum;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author yuyanghe
 * @date 2017年1月17日
 * @version 1.0
 * @since 2017年1月17日
 */
public class LC454_FourSumII
{

    public static void main(String[] args)
    {
        int[] a = { 1 }, b = { -1 }, c = { 0 }, d = { 1 };
        System.out.println(new LC454_FourSumII().fourSumCount(a, b, c, d));
    }

    public int fourSumCount(int[] a, int[] b, int[] c, int[] d)
    {
        // key - sum of a and b
        // value - how many times did this sum comes up?
        Map<Integer, Integer> mapAB = new HashMap<Integer, Integer>(), mapCD = new HashMap<Integer, Integer>();
        int ab = 0, res = 0;
        for (int i = 0; i < a.length; i++)
        {
            for (int j = 0; j < b.length; j++)
            {
                ab = a[i] + b[j];
                if (mapAB.containsKey(ab))
                {
                    mapAB.put(ab, mapAB.get(ab) + 1);
                }
                else
                {
                    mapAB.put(ab, 1);
                }
            }
        }

        for (int i = 0; i < c.length; i++)
        {
            for (int j = 0; j < d.length; j++)
            {
                ab = c[i] + d[j];
                if (mapCD.containsKey(ab))
                {
                    mapCD.put(ab, mapCD.get(ab) + 1);
                }
                else
                {
                    mapCD.put(ab, 1);
                }
            }
        }

        Set<Map.Entry<Integer, Integer>> set = mapAB.entrySet();
        for (Map.Entry<Integer, Integer> entry : set)
        {
            ab = entry.getKey() * -1;
            if (mapCD.containsKey(ab))
            {
                res += entry.getValue() * mapCD.get(ab);
            }
        }

        return res;
    }
}
