package com.yuyang.he.lc.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC288_Unique_Word_Abbreviation
{
    public static void main(String[] args)
    {
        LC288_Unique_Word_Abbreviation lc288 = new LC288_Unique_Word_Abbreviation(new String [] {"deer","door","cake","card"});
        System.out.println(lc288.isUnique("cart"));
    }
    
 // abbreviation -> words
    final Map<String, Set<String>> map = new HashMap<> ();
    final StringBuilder sb = new StringBuilder ();

    public LC288_Unique_Word_Abbreviation(final String[] dictionary) {
        for(final String word : dictionary) {
            final String abbreviation = getAbberviation(word);
            map.putIfAbsent(abbreviation, new HashSet<> ());
            map.get(abbreviation).add(word);
        }
    }
    
    public final boolean isUnique(final String word) {
        final String abbreviation = getAbberviation(word);
        if(map.containsKey(abbreviation)) {
            Set<String> words = map.get(abbreviation);
            if(words.contains(word) && 1 == words.size())
                return true;
            else return false;
        } else return true;
    }
    
    private String getAbberviation(final String word) {
        final int length = word.length();
        if(2 >= length)
            return word;
        sb.setLength(0);
        sb.append(word.charAt(0));
        sb.append(length - 2);
        sb.append(word.charAt(length - 1));
        return sb.toString();
    }
}
