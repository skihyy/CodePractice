package com.yuyang.he.lc.palindrome;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author yuyanghe
 * @date 2016年12月24日
 * @version 1.0
 * @since 2016年12月24日
 */
public class LC266_PalindromePermutation
{
    public static void main(String[] args)
    {
        System.out.println(new LC266_PalindromePermutation().palindromePermutation("TACT COA"));
    }

    public boolean palindromePermutation(String s)
    {
        if (null == s)
        {
            return true;
        }
        int len = s.length();
        if (0 == len || 1 == len)
        {
            return true;
        }

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        char c = 'a';

        for (int i = 0; i < len; ++i)
        {
            c = s.charAt(i);
            if (map.containsKey(c))
            {
                map.put(c, map.get(c) + 1);
            }
            else
            {
                map.put(c, 1);
            }
        }

        Set<Entry<Character, Integer>> entrySet = map.entrySet();

        int numOfOdd = 0;
        for (Entry<Character, Integer> entry : entrySet)
        {
            if (1 == entry.getValue() % 2)
            {
                numOfOdd++;
            }
        }

        // even length
        if (0 == len % 2)
        {
            if (0 == numOfOdd % 2)
            {
                return true;
            }
        }
        // odd length
        else
        {
            if (1 == numOfOdd)
            {
                return true;
            }
        }
        return false;
    }
}
