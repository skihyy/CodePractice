package com.yuyang.he.cc189_1_2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuyanghe
 * @date 2016年12月24日
 * @version 1.0
 * @since 2016年12月24日
 */
public class Permutation
{

    public static void main(String[] args)
    {
        System.out.println(new Permutation().checkPermutation("dog", "god"));
    }
    
    /**
     * Check if s is permutation of t.
     * @param s String
     * @param t String
     * @return the result
     */
    public boolean checkPermutation(String s, String t)
    {
        if(null == s && t == s)
        {
            return true;
        }
        else if(null == s || t == s)
        {
            return false;
        }
        
        int sLen = s.length(), tLen = t.length(), tmp = -1;
        if(sLen != tLen)
        {
            return false;
        }
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();    
        char c = 'l';
        
        for(int i = 0; i < sLen; ++i)
        {
            c = s.charAt(i);
            
            if(map.containsKey(c))
            {
                map.put(c, map.get(c) + 1);
            }
            else
            {
                map.put(c, 1);
            }
        }
        
        for(int i = 0; i < tLen; ++i)
        {
            c = t.charAt(i);
            
            if(map.containsKey(c))
            {
                tmp = map.get(c) - 1;
                if(0 > tmp)
                {
                    return false;
                }
                map.put(c, tmp);
            }
            else
            {
                return false;
            }
        }
        
        return true;
    }
}
