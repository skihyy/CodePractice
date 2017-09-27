package com.yuyang.he.lc.palindrome;

public class LC516_Longest_Palindromic_Subsequence
{

    public static void main(String[] args)
    {
        System.out.println(new LC516_Longest_Palindromic_Subsequence().longestPalindromeSubseq("bbbab"));
    }

    private int result = 0;

    public int longestPalindromeSubseq(String s)
    {
        final int length = s.length();
        if (null == s || 0 == length)
            return 0;
        for (int i = 0; i < length; i++)
        {
            // start at the index, extend palindrome if possible
            extendPalindrome(s, i, i, length, 1);
            extendPalindrome(s, i, i + 1, length, 2);
        }
        return result;
    }

    private void extendPalindrome(final String s, int left, int right, final int length, int curLen)
    {
        while (0 <= left && length > right && s.charAt(left) == s.charAt(right))
        {
            curLen++;
            left--;
            right++;
        }
        if (curLen > result)
            result = curLen;
    }

}
