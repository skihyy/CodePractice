package com.yuyang.he.lc.numbers;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuyanghe
 * @date 2017年1月11日
 * @version 1.0
 * @since 2017年1月11日
 */
public class LC273_NumToWords
{
    Map<Integer, String> numMap = new HashMap<Integer, String>(), digMap = new HashMap<Integer, String>();

    public LC273_NumToWords()
    {
        numMap.put(1, "One");
        numMap.put(2, "Two");
        numMap.put(3, "Three");
        numMap.put(4, "Four");
        numMap.put(5, "Five");
        numMap.put(6, "Six");
        numMap.put(7, "Seven");
        numMap.put(8, "Eight");
        numMap.put(9, "Nine");
        numMap.put(10, "Ten");
        numMap.put(11, "Eleven");
        numMap.put(12, "Twelve");
        numMap.put(13, "Thirteen");
        numMap.put(14, "Forteen");
        numMap.put(15, "Fifteen");
        numMap.put(16, "Sixteen");
        numMap.put(17, "Seventeen");
        numMap.put(18, "Eighteen");
        numMap.put(19, "Nineteen");
        numMap.put(20, "Twenty");
        numMap.put(30, "Thirty");
        numMap.put(40, "Forty");
        numMap.put(50, "Fifty");
        numMap.put(60, "Sixty");
        numMap.put(70, "Seventy");
        numMap.put(80, "Eighty");
        numMap.put(90, "Ninety");

        digMap.put(0, "");
        digMap.put(1, "Thousand");
        digMap.put(2, "Million");
        digMap.put(3, "Billion");
        digMap.put(4, "Trillion");
    }

    public static void main(String[] args)
    {
        System.out.println(new LC273_NumToWords().numToString(50868));
    }

    public String numToString(int num)
    {
        StringBuilder sb = new StringBuilder();
        String tmp = null;

        int[] splitNums = getSplitNums(num);

        for (int i = splitNums.length - 1; i >= 0; i--)
        {
            tmp = smallNumToString(splitNums[i]);
            if (!"".equals(tmp))
            {
                sb.append(tmp);
                sb.append(" ");
                sb.append(digMap.get(i));
                sb.append(" ");
            }
        }

        return sb.toString().trim();
    }

    /**
     * Split a number into 3-digit numbers.
     * 
     * @param num
     *            input
     * @return array of 3-digit numbers.
     */
    private int[] getSplitNums(int num)
    {
        int len = (num + "").length(), resLen = 0 == len % 3 ? len / 3 : len / 3 + 1;
        int[] result = new int[resLen];
        int tmp = -1;

        for (int i = 0; i < result.length; i++)
        {
            tmp = num % 1000;
            result[i] = tmp;
            num /= 1000;
        }

        return result;
    }

    /**
     * Only transfer a number smaller than 1000 to string.
     * 
     * @param num
     *            must smaller than 1000
     * @return string
     */
    private String smallNumToString(int num)
    {
        StringBuilder sb = new StringBuilder();

        int hundred = num / 100;

        if (0 != hundred)
        {
            sb.append(numMap.get(hundred) + " Hundred ");
        }

        int last2digit = num - 100 * hundred;

        if (0 < last2digit && 20 >= last2digit)
        {
            sb.append(numMap.get(last2digit));
        }
        else
        {
            int ten = last2digit / 10, one = last2digit % 10;

            if (0 != ten)
            {
                sb.append(numMap.get(ten * 10));
                sb.append(" ");
            }

            if (0 != one)
            {
                sb.append(numMap.get(one));
            }
        }

        return sb.toString().trim();
    }
}
