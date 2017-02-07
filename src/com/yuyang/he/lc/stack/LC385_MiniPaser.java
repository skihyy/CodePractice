package com.yuyang.he.lc.stack;

import java.util.Stack;

/**
 * @author yuyanghe
 * @version 1.0
 * @date 2017年2月6日
 * @since 2017年2月6日
 */
public class LC385_MiniPaser
{
    public static void main(String[] args)
    {
        NestedInteger res = deserialize("[123,[456,[789]]]");
        while (null != res)
        {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public static NestedInteger deserialize(String s)
    {
        Stack<Integer> stack = new Stack<Integer>();
        boolean isNeg = false, has_used = false;
        char[] cc = s.toCharArray();
        int num = 0;
        for (char c : cc)
        {
            switch (c)
            {
                case '[': // do nothing
                    break;
                case ']':
                    if (!has_used)
                    {
                        if (isNeg)
                        {
                            num *= -1;
                        }
                        stack.push(num);
                        num = 0;
                        isNeg = false;
                        has_used = true;
                    }
                    break;
                case '-':
                    isNeg = true;
                    break;
                case ',':
                    if (isNeg)
                    {
                        num *= -1;
                    }
                    stack.push(num);
                    num = 0;
                    isNeg = false;
                    break;
                default: // numbers
                    num *= 10;
                    num += c - '0';
                    break;
            }
        }

        if (!has_used)
        {
            if (isNeg)
            {
                num *= -1;
            }
            stack.push(num);
        }

        NestedInteger res = null;
        while (!stack.isEmpty())
        {
            num = stack.pop();
            if (null == res)
            {
                res = new NestedInteger(num);
            }
            else
            {
                NestedInteger tmp = new NestedInteger(num);
                tmp.add(res);
                res = tmp;
            }
        }

        return res;
    }

    static class NestedInteger
    {
        int val;
        NestedInteger next;

        public NestedInteger(int v)
        {
            val = v;
        }

        public void add(NestedInteger n)
        {
            next = n;
        }
    }
}
