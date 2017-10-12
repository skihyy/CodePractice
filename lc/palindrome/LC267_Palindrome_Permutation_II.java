package com.yuyang.he.lc.palindrome;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LC267_Palindrome_Permutation_II
{

    public static void main(String[] args)
    {
        System.out.println(new LC267_Palindrome_Permutation_II().generatePalindromes("aaa"));
    }
    
private final StringBuilder sb = new StringBuilder ();
    
    public final List<String> generatePalindromes(final String s) {
        final char [] cc = s.toCharArray();
        final Set<Character> set = new HashSet<> ();
        final Map<Character, Integer> map = new HashMap<> ();
        final List<String> result = new ArrayList<> ();
        final List<Character> chars = new ArrayList<> ();
        for(final char c : cc) {
            if(!set.add(c))
                set.remove(c);
            map.putIfAbsent(c, 0);
            map.put(c, map.get(c) + 1);
        }
        if(1 >= set.size()) { // can have palindrome
            final Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
            Character oddChar = null;
            for(final Map.Entry<Character, Integer> e : entrySet) {
                final int times = e.getValue();
                final char key = e.getKey();
                if(1 == (times & 1)) {// odd
                    oddChar = key;
                    for(int i = 1; i < times; i += 2) // only need half
                        chars.add(key);
                } else
                    for(int i = 0; i < times; i += 2) // only need half
                        chars.add(key);
            }
            helper(result, cc, sb, chars, oddChar);
        }
        return result;
    }
    
    private void helper(final List<String> result, final char [] cc, final StringBuilder sb, final List<Character> chars, final Character odd) {
        final int size = chars.size();
        if(0 == size) 
            result.add((null == odd ? sb.toString() + sb.reverse().toString() : sb.toString() + odd + sb.reverse().toString()));
        else {
            final int len = sb.length();
            for(int i = 0; i < size; i++) {
                final char remove = chars.get(i);
                sb.append(remove);
                chars.remove(i);
                helper(result, cc, sb, chars, odd);
                chars.add(i, remove);
                sb.setLength(len);
            }
        }
    }

}
