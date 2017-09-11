package com.yuyang.he.lc.numbers;

import java.util.Arrays;

public class LC468_ValidateIPAddress
{
    public static void main(String[] args)
    {
        System.out.println(new LC468_ValidateIPAddress().validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
    }

    public String validIPAddress(String IP)
    {
        if (IP.endsWith(":") || IP.endsWith("."))
            return "Neither";

        if (16 > IP.length() && 4 == Arrays.stream(IP.split("\\.")).filter(i ->
        {
            try
            {
                int tmp = Integer.parseInt(i);
                return 255 >= tmp && (tmp + "").length() == i.length() && '-' != i.charAt(0);
            }
            catch (NumberFormatException e)
            {
                return false;
            }
        }).count())
            return "IPv4";

        // if not IPv4
        if (IP.startsWith("0"))
            return "Neither";

        String[] parts = IP.split(":");
        return 8 == parts.length && parts.length == (int) Arrays.stream(parts).filter(i ->
        {
            try
            {
                Long.parseLong(i, 16);
                return 4 >= i.length() && '-' != i.charAt(0);
            }
            catch (NumberFormatException e)
            {
                return false;
            }
        }).count() ? "IPv6" : "Neither";
    }
}
