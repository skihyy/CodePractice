package com.yuyang.he.lc.dp;

public class LC474_Ones_And_Zeroes
{

    public static void main(String[] args)
    {
        System.out.println(new LC474_Ones_And_Zeroes().findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
    }

    public final int findMaxForm(final String[] strs, final int m, final int n)
    {
        return form(strs, 0, m, n);
    }

    private int form(final String[] s, final int index, final int m, final int n)
    {
        if (index == s.length || (0 == m && 0 == n))
            return 0;
        final char[] cc = s[index].toCharArray();
        int zeros = 0, ones = 0;
        for (final char c : cc)
            if ('0' == c)
                zeros++;
            else
                ones++;
        if (zeros > m || ones > n)
            return form(s, index + 1, m, n); // cannot form current string, go to the next one
        return Math.max(1 + form(s, index + 1, m - zeros, n - ones), form(s, index + 1, m, n));
    }

}
