package com.yuyang.he.lc.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC336_Palindrome_Pairs
{

    public static void main(String[] args)
    {
        System.out.println(
                new LC336_Palindrome_Pairs().palindromePairs(new String[] { "abcd", "dcba", "lls", "s", "sssll" }));
    }
    
private final StringBuilder sb = new StringBuilder ();
    
    // 1. "" + palindrome
    // 2. s + reverse(s)
    // 3. (t + r) is palinedrome
    public final List<List<Integer>> palindromePairs(final String[] words) {
        // word -> ID
        final Map<String, Integer> map = new HashMap<> ();
        for(int i = 0; i < words.length; i++)
            map.put(words[i], i);
        
        final List<List<Integer>> result = new ArrayList<> ();
        
        if(map.containsKey(""))
            for(final String word : words)
                if(!"".equals(word) && isPalinDrome(word)) {
                    result.add(Arrays.asList(map.get(""), map.get(word)));
                    result.add(Arrays.asList(map.get(word), map.get("")));
                }
        
        // reverse
        for(final String word : words)
            if(!"".equals(word)) {
                final String reverse = reverse(word);
                if(!word.equals(reverse) && map.containsKey(reverse))
                    result.add(Arrays.asList(map.get(reverse), map.get(word)));
            }
        
        // (t + r) is palindrome
        for(final String word : words) {
            // if part of t is palindrome
            final int len = word.length();
            for(int i = 1; i < len; i++) {
                if(isPalinDrome(word.substring(0, i))) {
                    final String rest = reverse(word.substring(i));
                    if(!rest.equals(word) && map.containsKey(rest))
                        result.add(Arrays.asList(map.get(rest), map.get(word)));
                }
                if(isPalinDrome(word.substring(i))) {
                    final String rest = reverse(word.substring(0, i));
                    if(!rest.equals(word) && map.containsKey(rest))
                        result.add(Arrays.asList(map.get(rest), map.get(word)));
                }
            }
        }
        
        return result;
    }
    
    private String reverse(final String s) {
        sb.setLength(0);
        sb.append(s);
        return sb.reverse().toString();
    }
    
    private boolean isPalinDrome(final String s) {
        final int len = s.length() - 1, limit = s.length() / 2;
        for(int i = 0; i < limit; i++)
            if(s.charAt(i) != s.charAt(len - i))
                return false;
        return true;
    }

}
