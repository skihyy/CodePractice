package com.yuyang.he.lc.amazon;

/**
 * @author yuyanghe
 * @date 2017年1月15日
 * @version 1.0
 * @since 2017年1月15日
 */
public class LC5_LongestPalindromicSubstring
{
    public static void main(String[] args)
    {
        System.out.println(new LC5_LongestPalindromicSubstring().longestPalindrome("ccc"));
    }

    private int low = 0, curLen = 0;

    public String longestPalindrome(String s)
    {
        int len = s.length();

        if (2 > len)
        {
            return s;
        }

        for (int i = 0; i < len - 1; i++)
        {
            helper(s, i, i);
            helper(s, i, i + 1);
        }

        return s.substring(low, low + curLen);
    }

    private void helper(String s, int left, int right)
    {
        int sLen = s.length(), len = 0;
        while (0 <= left && sLen > right && s.charAt(left) == s.charAt(right))
        {
            left--;
            right++;
        }

        len = right - left - 1;
        if (curLen < len)
        {
            low = left + 1;
            curLen = len;
        }
    }
}
