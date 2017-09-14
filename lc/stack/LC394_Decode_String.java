package com.yuyang.he.lc.stack;

import java.util.Stack;

public class LC394_Decode_String
{

    public static void main(String[] args)
    {
        System.out.println(new LC394_Decode_String().decodeString("2[2[b]]"));
    }

    private Stack<Character> stack = new Stack<>();
    private StringBuilder stringBuilder = new StringBuilder();

    public String decodeString(final String s)
    {
        char[] cc = s.toCharArray();

        for (char c : cc)
            if (']' == c)
            {
                helper();
            }
            else
                stack.push(c);

        helper();

        while (!stack.isEmpty())
            stringBuilder.append(stack.pop());
        return stringBuilder.reverse().toString();
    }

    private void helper()
    {
        if (stack.isEmpty())
            return;

        char t;
        while (!stack.isEmpty())
        {
            t = stack.peek();
            if ('[' != t && ('0' > t || '9' < t))
            {
                stringBuilder.append(t);
                stack.pop();
            }
            else
            {
                if ('[' == t)
                    stack.pop();
                break;
            }

        }
        String toRepeat = stringBuilder.reverse().toString();
        stringBuilder.setLength(0);

        // times
        while (!stack.isEmpty())
        {
            t = stack.peek();
            if ('0' <= t && '9' >= t)
            {
                stringBuilder.append(t);
                stack.pop();
            }
            else
            {
                if ('[' == t)
                    stack.pop();
                break;
            }
        }
        int times;
        if (0 < stringBuilder.length())
            times = Integer.parseInt(stringBuilder.reverse().toString());
        else
            times = 1;

        stringBuilder.setLength(0);

        for (int i = 0; i < times; i++)
            stringBuilder.append(toRepeat);

        char[] cc = stringBuilder.toString().toCharArray();
        for (char c : cc)
            stack.push(c);
        stringBuilder.setLength(0);
    }

}
