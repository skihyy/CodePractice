package com.yuyang.he.lc3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuyanghe
 * @date 2016年12月22日
 * @version 1.0
 * @since 2016年12月22日
 */
public class LC3
{
    public static void main(String[] args)
    {
        System.out.println(new LC3().lengthOfLongestSubstring("aabbbb"));
    }

    /**
     * Given a string, find the length of the longest substring without
     * repeating characters.
     * 
     * @param s
     *            string
     * @return the length of the longest substring without repeating characters
     */
    public int lengthOfLongestSubstring(String s)
    {
        if (null == s)
        {
            return 0;
        }

        int curLen = 0, maxLen = 0;
        Map<Integer, Character> iMap = new HashMap<Integer, Character>();
        Map<Character, Integer> cMap = new HashMap<Character, Integer>();

        char[] list = s.toCharArray();

        for (char c : list)
        {
            if (cMap.containsKey(c))
            {
                // if a repeating character found
                // delete the repeating one
                // also move all indices in the map
                curLen -= cMap.get(c);
                curLen++;

                removeRepeatingCharacter(c, cMap, iMap);
            }
            else
            {
                curLen++;
            }

            cMap.put(c, curLen);
            iMap.put(curLen, c);

            if (curLen > maxLen)
            {
                maxLen = curLen;
            }
        }

        return maxLen;
    }

    private void removeRepeatingCharacter(char c, Map<Character, Integer> cMap, Map<Integer, Character> iMap)
    {
        int size = iMap.size(), repeatingPos = cMap.get(c), count = 1;
        char tmp = '/';

        // remove all elements from the start to the repeating location
        for (int i = 1; i <= repeatingPos; ++i)
        {
            tmp = iMap.get(i);
            iMap.remove(i);
            cMap.remove(tmp);
        }

        // re-factor all other indices from 1 to ~
        for (int i = repeatingPos + 1; i <= size; ++i)
        {
            tmp = iMap.get(i);
            iMap.remove(i);
            iMap.put(count, tmp);
            cMap.put(tmp, count);
            count++;
        }
    }
}
