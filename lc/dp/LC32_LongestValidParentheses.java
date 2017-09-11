package com.yuyang.he.lc.dp;

import java.util.Stack;

/**
 * @author yuyanghe
 * @date 2017年1月18日
 * @version 1.0
 * @since 2017年1月18日
 */
public class LC32_LongestValidParentheses
{
    public static void main(String[] args)
    {
        System.out.println(new LC32_LongestValidParentheses().longestValidParentheses("(((()((())"));
    }

    public int longestValidParentheses(String s)
    {
        Stack<Integer> stack = new Stack<Integer>();
        int len = s.length(), max = 0, left = -1;
        for (int i = 0; i < len; i++)
        {
            if ('(' == s.charAt(i))
            {
                stack.push(i);
            }
            else
            {
                if (stack.isEmpty())
                {
                    left = i;
                }
                else
                {
                    stack.pop();
                    if (stack.isEmpty())
                    {
                        max = Math.max(max, i - left);
                    }
                    else
                    {
                        max = Math.max(max, i - stack.peek());
                    }
                }
            }
        }
        return max;
    }
}
