package com.yuyang.he.lc.string;

import java.util.ArrayList;
import java.util.List;

public class LC320_Generalized_Abbreviation
{

    public static void main(String[] args)
    {
        System.out.println(new LC320_Generalized_Abbreviation().generateAbbreviations("word"));
    }
    
    public final List<String> generateAbbreviations(final String word) {
        final List<String> result = new ArrayList<> ();
        result.add(word);
        final StringBuilder sb = new StringBuilder ();
        final int len = word.length();
        final char [] cc =word.toCharArray();
        for(int i = 1; i <= len; i++) { // how many characters to ignore
            // len   ignore   posiible outcome
            //  3       3            1
            //  3       2            2
            //  5       2            4
            final int possibleOutcome = len - i + 1;
            for(int j = 0; j < possibleOutcome; j++) { // how many possible outcomes under current situation
                sb.setLength(0);
                for(int k = 0; k < len; k++) { // generate one outcome
                    if(j == k) {
                        sb.append(i);
                        k += i - 1;
                    } else
                        sb.append(cc[k]);
                }
                result.add(sb.toString());
            }
        }
        return result;        
    }

}
