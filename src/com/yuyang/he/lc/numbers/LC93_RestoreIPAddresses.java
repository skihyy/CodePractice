package com.yuyang.he.lc.numbers;

import java.util.ArrayList;
import java.util.List;

public class LC93_RestoreIPAddresses
{

    public static void main(String[] args)
    {
        new LC93_RestoreIPAddresses().restoreIpAddresses("0000").stream().forEach(i -> System.out.println(i));
    }

    public List<String> restoreIpAddresses(String s)
    {
        List<String> res = new ArrayList<String>();
        helper(res, 0, s, "", 0, s.length());
        return res;
    }

    private void helper(List<String> res, int cur, String s, String ip, int len, int sLen)
    {
        if (4 == cur)
        {
            if (sLen == len)
                res.add(ip);
            return;
        }

        for (int i = 1; i < 4; i++)
        {
            if (sLen < i + len)
                break;
            String tmp = s.substring(len, i + len);
            if ((1 != tmp.length() && tmp.startsWith("0")) || (3 == i && 255 < Integer.parseInt(tmp)))
                continue;
            helper(res, cur + 1, s, ip + tmp + (3 != cur ? "." : ""), len + i, sLen);
        }
    }
}
