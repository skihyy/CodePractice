package com.yuyang.he.lc.romanInteger;
/**
 * @author yuyanghe
 * @date 2017年1月11日
 * @version 1.0
 * @since 2017年1月11日
 */
public class LC12_IntToRoman
{

    public static void main(String[] args)
    {
        System.out.println(new LC12_IntToRoman().intToRoman(1920));
    }

    public String intToRoman(int num)
    {
        if (1 > num || 3999 < num)
        {
            return "";
        }

        String[] val = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        int[] key = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

        StringBuilder sb = new StringBuilder();
        int i = 0;

        while (0 < num)
        {
            if(key[i] <= num)
            {
                sb.append(val[i]);
                num -= key[i];
            }
            else
            {
                ++i;
            }
        }
        
        return sb.toString();
    }

}
