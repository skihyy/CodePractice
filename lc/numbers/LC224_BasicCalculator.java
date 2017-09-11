package com.yuyang.he.lc.numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC224_BasicCalculator
{

    public static void main(String[] args)
    {
        System.out.println(new LC224_BasicCalculator().calculate("(1+(4+5+2)-3)+(6+8)"));
    }

    public int calculate(String s)
    {
        Stack<String> stack = new Stack<String>();
        StringBuilder sb = new StringBuilder();
        char[] cc = s.toCharArray();
        List<String> tmp = new ArrayList<String>();
        String ts = null;
        for (char c : cc)
        {
            if (' ' == c)
                continue;
            if ('0' <= c && '9' >= c)
            {
                sb.append(c);
                continue;
            }
            // now char c is an operator + - ( )
            // so put the number into stack
            if (0 < sb.length())
            {
                stack.add(sb.toString());
                sb.setLength(0);
            }
            // no need to put brackets, will handle immediately
            if (')' != c)
            {
                stack.add(Character.toString(c));
                continue;
            }
            // if is ')', then compute
            while (true)
            {
                ts = stack.pop();
                if ("(".equals(ts))
                    break;
                tmp.add(ts);
            }
            stack.add(Integer.toString(calculate(tmp)));
            tmp.clear();
        }

        if (0 != sb.length())
            stack.add(sb.toString());

        List<String> list = new ArrayList<String>();
        while (!stack.isEmpty())
            list.add(stack.pop());

        return calculate(list);
    }

    private int calculate(List<String> list)
    {
        String op = null;
        int size = list.size(), res = 0 == size ? 0 : Integer.parseInt(list.get(size - 1)), tmp = 0;
        for (int i = size - 2; i >= 0; i -= 2)
        {
            op = list.get(i);
            tmp = Integer.parseInt(list.get(i - 1));
            switch (op)
            {
                case "+":
                    res += tmp;
                    break;
                case "-":
                    res -= tmp;
                    break;
            }
        }
        return res;
    }

}
