package com.yuyang.he.lc.subsetsAndCombinations;

import java.util.ArrayList;
import java.util.List;
/**
 * @author yuyanghe
 * @date 2017年1月11日
 * @version 1.0
 * @since 2017年1月11日
 */
public class LC17_LetterCombinations
{
    public static void main(String[] args)
    {
        List<String> res = new LC17_LetterCombinations().letterCombinations("23");
        for (String s : res)
        {
            System.out.println(s);
        }
    }

    public List<String> letterCombinations(String digits)
    {
        if ("".equals(digits))
        {
            return new ArrayList<String>();
        }
        
        char[] cc = digits.toCharArray();
        List<String> res = new ArrayList<String>();
        List<char[]> possibleComb = new ArrayList<char[]>();

        for (char c : cc)
        {
            possibleComb.add(getPossibleLetters(c));
        }

        getCombinations(res, "", possibleComb, cc.length, 0);

        return res;
    }

    private void getCombinations(List<String> res, String curStr, List<char[]> possibleComb, int limit, int curIndex)
    {
        if (0 == limit)
        {
            res.add(curStr);
            return;
        }

        char[] curPosCom = possibleComb.get(curIndex);

        for (char c : curPosCom)
        {
            getCombinations(res, curStr + c, possibleComb, limit - 1, curIndex + 1);
        }
    }

    private char[] getPossibleLetters(char ch)
    {
        switch (ch)
        {
            case '2':
                char[] a = { 'a', 'b', 'c' };
                return a;
            case '3':
                char[] b = { 'd', 'e', 'f' };
                return b;
            case '4':
                char[] c = { 'g', 'h', 'i' };
                return c;
            case '5':
                char[] d = { 'j', 'k', 'l' };
                return d;
            case '6':
                char[] e = { 'm', 'n', 'o' };
                return e;
            case '7':
                char[] f = { 'p', 'q', 'r', 's' };
                return f;
            case '8':
                char[] g = { 't', 'u', 'v' };
                return g;
            case '9':
                char[] h = { 'w', 'x', 'y', 'z' };
                return h;
            case '0':
                char[] i = { ' ' };
                return i;
            default:
                char[] l = { 'a', 'b', 'c' };
                return l;
        }
    }
}