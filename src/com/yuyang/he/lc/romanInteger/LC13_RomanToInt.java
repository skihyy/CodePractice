package com.yuyang.he.lc.romanInteger;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuyanghe
 * @date 2017年1月11日
 * @version 1.0
 * @since 2017年1月11日
 */
public class LC13_RomanToInt
{

    public static void main(String[] args)
    {
        System.out.println(new LC13_RomanToInt().romanToInt("DCXXI"));
    }

    public int romanToInt(String s)
    {
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        char[] c = s.toCharArray();
        int result = map.get(c[c.length - 1]);

        for (int i = c.length - 2; i >= 0; i--)
        {
            if (map.get(c[i]) >= map.get(c[i + 1]))
            {
                result += map.get(c[i]);
            }
            else
            {
                result -= map.get(c[i]);
            }
        }

        return result;
    }

}
