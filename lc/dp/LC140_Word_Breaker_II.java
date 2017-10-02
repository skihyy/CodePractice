package com.yuyang.he.lc.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC140_Word_Breaker_II
{

    public static void main(String[] args)
    {
        System.out.println(new LC140_Word_Breaker_II().wordBreak("catsanddog", Arrays.asList("cat","cats","and","sand","dog")));
    }
    
    public final List<String> wordBreak(final String s, final List<String> wordDict) {
        final int len = s.length();
        int maxLen = 0; // to shrink time, find the longest length in dictionary
        for(final String word : wordDict)
            maxLen = Math.max(maxLen, word.length());
        final Map<Integer, List<String>> dp = new HashMap<> ();
        dp.put(len, Arrays.asList("")); // initialization
        for(int i = len - 1; 0 <= i; i--) {
            final List<String> result = new ArrayList<> ();
            for(int j = i + 1; len >= j; j++) {
                final String curWord = s.substring(i, j);
                if(maxLen < curWord.length())
                    break;
                if(wordDict.contains(curWord)) {
                    final List<String> tmp = dp.get(j);
                    for(final String w : tmp)
                        result.add(curWord + (w.isEmpty() ? "" : " ") + w);
                }
            }
            dp.put(i, result);
        }
        return dp.get(0);
    }

}
