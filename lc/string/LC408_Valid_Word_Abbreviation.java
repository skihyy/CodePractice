package com.yuyang.he.lc.string;

public class LC408_Valid_Word_Abbreviation
{

    public static void main(String[] args)
    {
        System.out.println(new LC408_Valid_Word_Abbreviation().validWordAbbreviation("hi", "2i"));
    }
    
    public final boolean validWordAbbreviation(final String word, final String abbr) {
     // numLeft / right => the number position in the abbreviation
        int posInWord = 0, numLeft = 0, numRight = -1;
        boolean isNum = false;
        final int abLen = abbr.length(), wordLen = word.length();
        int i = 0; // i => posInAbbr
        for(; i < abLen; i++) {
            final char c = abbr.charAt(i);
            if('0' <= c && '9' >= c) // number
                if(!isNum) {
                    if('0' == c) // cannot start with 0
                        return false;
                    isNum = true;
                    numLeft = numRight = i;                    
                } else
                    numRight = i;
            else { // character
                if(isNum) {
                    isNum = false;
                    posInWord += Integer.parseInt(abbr.substring(numLeft, numRight + 1));
                }  
                if(wordLen <= posInWord)
                    break;
                if(word.charAt(posInWord++) != c)
                    return false;
            }
        }
        if(isNum) // at the end of the abbreviation, it is a number
            posInWord += Integer.parseInt(abbr.substring(numLeft, numRight + 1));
        return wordLen == posInWord && i == abLen;
    }

}
