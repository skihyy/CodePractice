package com.yuyang.he.lc8;

/**
 * @author yuyanghe
 * @date 2016年12月22日
 * @version 1.0
 * @since 2016年12月22日
 */
public class LC8
{
    public static void main(String[] args)
    {
        System.out.println(new LC8().myAtoi("-"));
    }

    /**
     * Implement atoi to convert a string to an integer.
     * @param str string
     * @return integer
     */
    public int myAtoi(String str)
    {
        str = str.trim();
        if (null == str || 0 == str.length())
        {
            return 0;
        }

        char[] cc = str.toCharArray();
        char tmp = 'a';
        long result = 0;
        double pow = 0;
        boolean isNeg = false;
        int stopPos = 0;

        if ('-' == cc[0])
        {
            isNeg = true;
            stopPos = 1;
        }
        else if ('+' == cc[0])
        {
            stopPos = 1;
        }

        for (int i = cc.length - 1; i >= stopPos; i--)
        {
            tmp = cc[i];
            if (tmp < '0' || tmp > '9')
            {
                result = 0;
                pow = 0;
                continue;
            }

            result += (int) Math.pow(10.0, pow) * (tmp - '0');
            pow += 1;
        }

        if (isNeg)
        {
            if (result > ((long) (Integer.MAX_VALUE) + 1))
            {
                return Integer.MIN_VALUE;
            }
        }
        else
        {
            if (result > Integer.MAX_VALUE)
            {
                return Integer.MAX_VALUE;
            }
        }

        return isNeg ? (int) (-1 * result) : (int) result;
    }
}
