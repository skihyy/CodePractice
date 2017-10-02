package com.yuyang.he.lc.twopointers;

import java.util.HashMap;
import java.util.Map;

public class LC76_Minimum_Window_Substring
{

    public static void main(String[] args)
    {
        System.out.println(new LC76_Minimum_Window_Substring().minWindow("bba", "ab"));
    }
    
    public final String minWindow(final String s, final String t) {
        // the number of times characters in t appeared
        final Map<Character, Integer> dict = new HashMap<> ();
        final int s_size = s.length(), t_size = t.length();
        final char [] tt = t.toCharArray();
        for(final char c : tt)
            dict.put(c, dict.getOrDefault(c, 0) + 1);
        // char in current window => the times occurred
        final char [] cc = s.toCharArray();
        int left = 0, right = 0;
        String result = "";
        int currentCharacterCount = 0;
        while(right < s_size) {
            final char c = cc[right++];
            if(dict.containsKey(c))
                dict.put(c, dict.get(c) - 1);
            if(0 <= dict.get(c))
                currentCharacterCount++;
            while(currentCharacterCount == t_size) {
                final String tmpResult = s.substring(left, right);
                if("".equals(result) || result.length() > tmpResult.length())
                    result = tmpResult;
                final char l = cc[left++];
                if(dict.containsKey(l)) {
                    dict.put(l, dict.get(l) + 1);
                    if(0 < dict.get(l))
                        currentCharacterCount--;
                }
            }                
        }
        return result;
    }
}
