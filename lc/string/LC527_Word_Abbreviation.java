package com.yuyang.he.lc.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LC527_Word_Abbreviation
{

    public static void main(String[] args)
    {
        System.out.println(new LC527_Word_Abbreviation().wordsAbbreviation(Arrays.asList("leetcode")));
    }
    
    public final List<String> wordsAbbreviation(final List<String> dict) {
        final Map<String, String> wordToAbbr = new HashMap<> ();
        // group by length
        final Map<Integer, List<String>> lenToWord = new HashMap<> ();
        for(final String word : dict) {
            final int len = word.length();
            if(4 > len)
                wordToAbbr.put(word, word);
            else {
                lenToWord.putIfAbsent(len, new ArrayList<> ());
                lenToWord.get(len).add(word);
            }
        }
        // generate unique abbreviation
        final Set<Map.Entry<Integer, List<String>>> set = lenToWord.entrySet();
        for(final Map.Entry<Integer, List<String>> e : set) {
            final List<String> words = e.getValue();
            final int len = words.size(), wordLen = e.getKey();
            if(1 == len)
                wordToAbbr.put(words.get(0), getAbbr(words.get(0), 1, wordLen));
            else { // many words, generate abbreviation by increasing the length until there is no same abbreviations
                for(int i = 1; i <= wordLen - 2; i++) {
                    final Map<String, String> abbrToWord = new HashMap<> ();
                    // generate all possible result
                    for(final String word : words) {
                        if(wordToAbbr.containsKey(word))
                            continue;
                        final String abbr = getAbbr(word, i, wordLen);
                        if(abbrToWord.containsKey(abbr)) // found duplicate
                            abbrToWord.put(abbr, "");
                        else
                            abbrToWord.put(abbr, word);
                    }
                    // put non-duplicate word into result
                    final Set<Map.Entry<String, String>> tmpSet = abbrToWord.entrySet();
                    for(final Map.Entry<String, String> me : tmpSet) {
                        final String val = me.getValue();
                        if(!val.isEmpty())
                            wordToAbbr.put(val, me.getKey());
                    }
                }
            }
        }
        // order result
        final List<String> result = new ArrayList<> ();
        dict.forEach(i -> result.add(wordToAbbr.get(i)));
        return result;
    }
    
    // start => the start position of prefix
    private String getAbbr(final String word, final int start, final int len) {
        return 1 == len - start - 1 ? word : word.substring(0, start) + (len - start - 1) + word.charAt(len - 1);
    }

}
